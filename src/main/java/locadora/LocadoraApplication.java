package locadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LocadoraApplication {
	private static final Logger logger = LoggerFactory.getLogger(LocadoraApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
		logger.info("Sistema iniciado");
	}

}
