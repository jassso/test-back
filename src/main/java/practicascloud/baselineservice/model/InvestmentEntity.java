/**
 * 
 */
package practicascloud.baselineservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cjasso
 *
 */
@Entity
@Table(name = "investments")
public class InvestmentEntity {

	/**
	 * 
	 */
	public InvestmentEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * Año
	 */
	private int year;
	
	/**
	 * SaldoInicial
	 */
	@Column(name = "initial_balance")
	private BigDecimal initialBalance;
	
	/**
	 * Aportación
	 */
	private BigDecimal contribution;
	
	/**
	 * Rendimiento
	 */
	@Column(name = "investment_return")
	private BigDecimal yearlyInvestmentReturn;
	
	/**
	 * Saldo final
	 */
	@Column(name = "final_balance")
	private BigDecimal finalBalance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
