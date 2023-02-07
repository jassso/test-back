package practicascloud.baselineservice;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaselineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaselineServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;
	}
	
}
