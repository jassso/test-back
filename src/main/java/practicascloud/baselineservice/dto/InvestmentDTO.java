/**
 * 
 */
package practicascloud.baselineservice.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * @author cjasso
 *
 */
//@Getter
//@Setter
public class InvestmentDTO {

	/**
	 * 
	 */
	public InvestmentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private BigDecimal initialInvestment;
	private BigDecimal annualContribution;
	private Integer annualContributionIncreasement;
	private Integer yearsOfInvestment;
	private Integer investmentReturn;
	
	public BigDecimal getInitialInvestment() {
		return initialInvestment;
	}
	public void setInitialInvestment(BigDecimal initialInvestment) {
		this.initialInvestment = initialInvestment;
	}
	public BigDecimal getAnnualContribution() {
		return annualContribution;
	}
	public void setAnnualContribution(BigDecimal annualContribution) {
		this.annualContribution = annualContribution;
	}
	public Integer getAnnualContributionIncreasement() {
		return annualContributionIncreasement;
	}
	public void setAnnualContributionIncreasement(Integer annualContributionIncreasement) {
		this.annualContributionIncreasement = annualContributionIncreasement;
	}
	public Integer getYearsOfInvestment() {
		return yearsOfInvestment;
	}
	public void setYearsOfInvestment(Integer yearsOfInvestment) {
		this.yearsOfInvestment = yearsOfInvestment;
	}
	public Integer getInvestmentReturn() {
		return investmentReturn;
	}
	public void setInvestmentReturn(Integer investmentReturn) {
		this.investmentReturn = investmentReturn;
	}
	

}
