/**
 * 
 */
package practicascloud.baselineservice.exception;

import practicascloud.baselineservice.util.Constants;

/**
 * @author cjasso
 *
 */
public class InvalidInvestmentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidInvestmentException() {
		super(Constants.BAD_PROVIDED_INVESTMENT_DATA);
	}

}
