package locadora;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import locadora.domain.Acervo;
import locadora.domain.AcervoRepository;
import locadora.domain.Cliente;
import locadora.domain.ClienteRepository;
import locadora.domain.EmprestimoRepository;
import locadora.domain.Exemplar;
import locadora.domain.ExemplarRepository;
import locadora.domain.ItemEmprestimoRepository;
import locadora.domain.TipoAcervo;
import locadora.domain.TipoClassificacao;
import locadora.domain.TipoMidia;

@SpringBootApplication
public class LocadoraApplication {
	@Autowired
	private AcervoRepository acervo;
	private ClienteRepository cliente;
	private EmprestimoRepository emprestimo;
	private ExemplarRepository exemplar;
	private ItemEmprestimoRepository itemEmprestimo;
	
	private static final Logger logger = LoggerFactory.getLogger(LocadoraApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
		logger.info("Sistema iniciado");
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Cliente c1 = new Cliente("001", "Isaac", "rua 1", "40028922", "Benfica", "606060");
			Cliente c2 = new Cliente("002", "João", "rua 2", "40028922", "Benfica", "606061");
			Cliente c3 = new Cliente("003", "Natam", "rua 3", "40028922", "Benfica", "606062");
			Cliente c4 = new Cliente("004", "marcos", "rua 4", "40028922", "Benfica", "606063");
			Cliente c5 = new Cliente("005", "Joana", "rua 5", "40028922", "Benfica", "606064");
			Cliente c6 = new Cliente("006", "Samiris", "rua 6", "40028922", "Benfica", "606065");
			
			cliente.save(c1);
			cliente.save(c2);
			cliente.save(c3);
			cliente.save(c4);
			cliente.save(c5);
			cliente.save(c6);
			
			Acervo a1 = new Acervo("001", "Alice no país das maravilhas", (float)2.30, TipoAcervo.FILME, TipoClassificacao.PRATA, TipoMidia.DVD);
			Acervo a2 = new Acervo("002", "Nightmare", (float)5, TipoAcervo.MUSICA, TipoClassificacao.BRONZE, TipoMidia.FITA);
			Acervo a3 = new Acervo("003", "Super Mario", (float)16.50, TipoAcervo.VIDEOGAME, TipoClassificacao.OURO, TipoMidia.DVD);
			Acervo a4 = new Acervo("004", "Lagoa Azul", (float)1.20, TipoAcervo.FILME, TipoClassificacao.LANCAMENTO, TipoMidia.DVD);
			Acervo a5 = new Acervo("005", "Paranoid", (float)10, TipoAcervo.MUSICA, TipoClassificacao.OURO, TipoMidia.CD);
			Acervo a6 = new Acervo("006", "ARK Survive", (float)32.75, TipoAcervo.VIDEOGAME, TipoClassificacao.LANCAMENTO, TipoMidia.DVD);
			
			acervo.save(a1);
			acervo.save(a2);
			acervo.save(a3);
			acervo.save(a4);
			acervo.save(a5);
			acervo.save(a6);
			
			Exemplar e1 = new Exemplar(1, new Date(), a1);
			Exemplar e2 = new Exemplar(2, new Date(), a1);
			Exemplar e3 = new Exemplar(3, new Date(), a1);
			Exemplar e4 = new Exemplar(1, new Date(), a2);
			Exemplar e5 = new Exemplar(2, new Date(), a2);
			Exemplar e6 = new Exemplar(3, new Date(), a2);
			Exemplar e7 = new Exemplar(1, new Date(), a3);
			Exemplar e8 = new Exemplar(2, new Date(), a3);
			Exemplar e9 = new Exemplar(3, new Date(), a3);
			Exemplar e10 = new Exemplar(1, new Date(), a4);
			Exemplar e11 = new Exemplar(2, new Date(), a4);
			Exemplar e12 = new Exemplar(3, new Date(), a4);
			Exemplar e13 = new Exemplar(1, new Date(), a5);
			Exemplar e14 = new Exemplar(2, new Date(), a5);
			Exemplar e15 = new Exemplar(3, new Date(), a5);
			Exemplar e16 = new Exemplar(1, new Date(), a6);
			Exemplar e17 = new Exemplar(2, new Date(), a6);
			Exemplar e18 = new Exemplar(3, new Date(), a6);
			
			exemplar.save(e1);
			exemplar.save(e2);
			exemplar.save(e3);
			exemplar.save(e4);
			exemplar.save(e5);
			exemplar.save(e6);
			exemplar.save(e7);
			exemplar.save(e8);
			exemplar.save(e9);
			exemplar.save(e10);
			exemplar.save(e11);
			exemplar.save(e12);
			exemplar.save(e13);
			exemplar.save(e14);
			exemplar.save(e15);
			exemplar.save(e16);
			exemplar.save(e17);
			exemplar.save(e18);
			
			a1.addExemplar(e1);
			a1.addExemplar(e2);
			a1.addExemplar(e3);
			a2.addExemplar(e4);
			a2.addExemplar(e5);
			a2.addExemplar(e6);
			a3.addExemplar(e7);
			a3.addExemplar(e8);
			a3.addExemplar(e9);
			a4.addExemplar(e10);
			a4.addExemplar(e11);
			a4.addExemplar(e12);
			a5.addExemplar(e13);
			a5.addExemplar(e14);
			a5.addExemplar(e15);
			a6.addExemplar(e16);
			a6.addExemplar(e17);
			a6.addExemplar(e18);
		};
	}

}
