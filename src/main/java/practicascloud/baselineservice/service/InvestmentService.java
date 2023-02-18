/**
 * 
 */
package practicascloud.baselineservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import practicascloud.baselineservice.dto.InvestmentDTO;
import practicascloud.baselineservice.dto.InvestmentResponseDTO;
import practicascloud.baselineservice.dto.YearlyInvestmentDTO;
import practicascloud.baselineservice.exception.InvalidInvestmentException;
import practicascloud.baselineservice.model.InvestmentEntity;
import practicascloud.baselineservice.repository.InvestmentRepository;
import practicascloud.baselineservice.util.Constants;

/**
 * @author cjasso
 *
 */
@Service
public class InvestmentService {

	private InvestmentRepository repository;
	
	private ModelMapper modelmapper;
	private ObjectMapper mapping = new ObjectMapper();

	private final BigDecimal oneHundred = new BigDecimal(100);
	private final BigDecimal one = new BigDecimal(1);
	private final BigDecimal zero =new BigDecimal(0);
	
	/**
	 * 
	 */
	public InvestmentService(InvestmentRepository repo, ModelMapper mapper) {
		this.repository = repo;
		this.modelmapper = mapper;
	}
	
	public ResponseEntity<InvestmentResponseDTO> invest(InvestmentDTO investment) {
		
		InvestmentResponseDTO response = new InvestmentResponseDTO();
		try {
			
			List<InvestmentEntity> investments = new ArrayList<>();

			for (int year = 1; year <= investment.getYearsOfInvestment(); year++) {

				InvestmentEntity yearInvestment = new InvestmentEntity();

				yearInvestment.setYear(year);
				BigDecimal initialBalance = null;
				BigDecimal contribution = null;
				BigDecimal annualContributionFactor = null;
				BigDecimal currentYearlyInvestmentReturn = new BigDecimal("0");
				BigDecimal yearFinalBalance = null;

				if (Constants.INVESTMENT_FOR_FIRST_YEAR == year) {
					
					initialBalance = investment.getInitialInvestment();
					contribution = investment.getAnnualContribution();
					
				} else {
					
					initialBalance = investments.get(year-Constants.INDEX_FOR_LAST_YEAR).getFinalBalance();
					contribution = 
							new BigDecimal("" + investments.get(year-Constants.INDEX_FOR_LAST_YEAR).getContribution());
					annualContributionFactor = new BigDecimal(investment.getAnnualContributionIncreasement());
//					annualContributionFactor = annualContributionFactor.divide(new BigDecimal(100));
					annualContributionFactor = BigDecimal.valueOf(annualContributionFactor.divide(oneHundred, 5, RoundingMode.DOWN).doubleValue());
					annualContributionFactor = annualContributionFactor.add(one);
					contribution = contribution.multiply(annualContributionFactor);
				}

				yearInvestment.setInitialBalance(initialBalance.setScale(2, RoundingMode.DOWN));
				yearInvestment.setContribution(contribution.setScale(2, RoundingMode.DOWN));
				
				currentYearlyInvestmentReturn = getCurrentYearlyInvestmentReturn(initialBalance, contribution, investment.getInvestmentReturn());
				yearInvestment.setYearlyInvestmentReturn(currentYearlyInvestmentReturn);
						
				yearFinalBalance = zero;
				yearFinalBalance = yearFinalBalance.add(initialBalance);
				yearFinalBalance = yearFinalBalance.add(contribution);
				yearFinalBalance = yearFinalBalance.add(currentYearlyInvestmentReturn);
				yearInvestment.setFinalBalance(yearFinalBalance.setScale(2, RoundingMode.DOWN));

				investments.add(yearInvestment);
			}

			repository.saveAllAndFlush(investments);
			
			BigDecimal finalInvestmentBalance = 
					new BigDecimal("" + investments.get(investments.size()-1).getFinalBalance());
			response.setFinalBalance(finalInvestmentBalance.setScale(2, RoundingMode.DOWN));
			BigDecimal finalSummation = 
					investments.stream().
					map(InvestmentEntity::getContribution).
					reduce(BigDecimal.ZERO, BigDecimal::add);
			
			BigDecimal investmentEarnings = finalInvestmentBalance.subtract(investment.getInitialInvestment()).
					subtract(finalSummation);
			
			response.setInvestmentEarnings(investmentEarnings.setScale(2, RoundingMode.DOWN));
			
			List<YearlyInvestmentDTO> yearlyInvestmentDTOs = investments.
					stream().
					map(inv -> modelmapper.map(inv, YearlyInvestmentDTO.class)).
					collect(Collectors.toList());
			
			response.getInvestments().addAll(yearlyInvestmentDTOs);
					
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidInvestmentException();
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param initialBalance
	 * @param contribution
	 * @param investmentReturn
	 * @return
	 */
	private BigDecimal getCurrentYearlyInvestmentReturn(
			BigDecimal initialBalance, 
			BigDecimal contribution, 
			Integer investmentReturn ) {
		BigDecimal currentYearlyInvestmentReturn = new BigDecimal("0");
		currentYearlyInvestmentReturn = currentYearlyInvestmentReturn.add(initialBalance);
		currentYearlyInvestmentReturn = currentYearlyInvestmentReturn.add(contribution);
		BigDecimal currentInvestmentReturn = new BigDecimal("" + investmentReturn);
		currentInvestmentReturn = BigDecimal.valueOf(currentInvestmentReturn.divide(oneHundred, 5, RoundingMode.DOWN).doubleValue());
		currentYearlyInvestmentReturn = currentYearlyInvestmentReturn.multiply(currentInvestmentReturn);
		return currentYearlyInvestmentReturn.setScale(2, RoundingMode.DOWN);
	}

}
