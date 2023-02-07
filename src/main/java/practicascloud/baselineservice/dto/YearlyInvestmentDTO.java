/**
 * 
 */
package practicascloud.baselineservice.dto;

import java.math.BigDecimal;

/**
 * @author cjasso
 *
 */
public class YearlyInvestmentDTO {

	/**
	 * 
	 */
	public YearlyInvestmentDTO() {
		// TODO Auto-generated constructor stub
	}
	

	private int year;
	
	private BigDecimal initialBalance;
	
	private BigDecimal contribution;
	
	private BigDecimal yearlyInvestmentReturn;
	
	private BigDecimal finalBalance;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	public BigDecimal getContribution() {
		return contribution;
	}

	public void setContribution(BigDecimal contribution) {
		this.contribution = contribution;
	}

	public BigDecimal getYearlyInvestmentReturn() {
		return yearlyInvestmentReturn;
	}

	public void setYearlyInvestmentReturn(BigDecimal yearlyInvestmentReturn) {
		this.yearlyInvestmentReturn = yearlyInvestmentReturn;
	}

	public BigDecimal getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(BigDecimal finalBalance) {
		this.finalBalance = finalBalance;
	}
	


}
