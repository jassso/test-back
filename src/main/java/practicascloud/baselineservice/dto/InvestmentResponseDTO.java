/**
 * 
 */
package practicascloud.baselineservice.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cjasso
 *
 */
public class InvestmentResponseDTO {

	/**
	 * 
	 */
	public InvestmentResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	private List<YearlyInvestmentDTO> investments = new ArrayList<YearlyInvestmentDTO>();
	private BigDecimal finalBalance;
	private BigDecimal investmentEarnings;
	public List<YearlyInvestmentDTO> getInvestments() {
		return investments;
	}
	public void setInvestments(List<YearlyInvestmentDTO> investments) {
		this.investments = investments;
	}
	public BigDecimal getFinalBalance() {
		return finalBalance;
	}
	public void setFinalBalance(BigDecimal finalBalance) {
		this.finalBalance = finalBalance;
	}
	public BigDecimal getInvestmentEarnings() {
		return investmentEarnings;
	}
	public void setInvestmentEarnings(BigDecimal investmentEarnings) {
		this.investmentEarnings = investmentEarnings;
	}

}
