/**
 * 
 */
package practicascloud.baselineservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicascloud.baselineservice.dto.InvestmentDTO;
import practicascloud.baselineservice.dto.InvestmentResponseDTO;
import practicascloud.baselineservice.service.InvestmentService;
import practicascloud.baselineservice.util.Constants;

/**
 * @author cjasso
 *
 */
@RestController
@RequestMapping("/Invest")
@CrossOrigin(origins = {Constants.ORIGIN_ALLOWED})
public class InvestmentController {

	private InvestmentService investmentService;
	
	/**
	 * 
	 */
	public InvestmentController(InvestmentService investmentServ) {
		this.investmentService = investmentServ;
	}
	
	/**
	 * 
	 * @param investmentDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<InvestmentResponseDTO> invest(@RequestBody InvestmentDTO investment) {
		return investmentService.invest(investment);
	}
	
	/**
	 * 
	 * @param investmentDTO
	 * Test to validate all is working
	 * @return
	 */
	@GetMapping
	public ResponseEntity<String> invest() {
		return new ResponseEntity<String>("Holi", HttpStatus.OK);
	}

}
