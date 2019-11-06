package locadora;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import locadora.domain.Cliente;
import locadora.domain.ClienteRepository;

@SpringBootApplication
public class LocadoraApplication {
	@Autowired
	private ClienteRepository repository;
	private static final Logger logger = LoggerFactory.getLogger(LocadoraApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
		logger.info("Sistema iniciado");
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			repository.save(new Cliente("001", "Isaac", "rua 1", "40028922", "Benfica", "606060"));
			repository.save(new Cliente("002", "João", "rua 2", "8540028922", "Benfica", "606061"));
		};
	}

}
