/**
 * 
 */
package practicascloud.baselineservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author cjasso
 *
 */
public class InvestmentExceptionAdvise extends ResponseEntityExceptionHandler{

	/**
	 * 
	 */
	public InvestmentExceptionAdvise() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(InvalidInvestmentException.class)
	public ResponseEntity<Object> handleBadInvestmentData(InvalidInvestmentException invalidInvestment) {
		
		InvalidInvestmentException exception = new InvalidInvestmentException();
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);	
	}

}
