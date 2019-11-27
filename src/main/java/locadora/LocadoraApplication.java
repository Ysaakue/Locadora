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
import locadora.domain.Emprestimo;
import locadora.domain.EmprestimoRepository;
import locadora.domain.Exemplar;
import locadora.domain.ExemplarRepository;
import locadora.domain.ItemEmprestimo;
import locadora.domain.ItemEmprestimoRepository;
import locadora.domain.TipoAcervo;
import locadora.domain.TipoClassificacao;
import locadora.domain.TipoMidia;

@SpringBootApplication
public class LocadoraApplication {
	@Autowired
	private AcervoRepository acervo;
	@Autowired
	private ClienteRepository clienteR;
	@Autowired
	private EmprestimoRepository emprestimo;
	@Autowired
	private ExemplarRepository exemplar;
	@Autowired
	private ItemEmprestimoRepository itemEmprestimo;
	
	private static final Logger logger = LoggerFactory.getLogger(LocadoraApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
		logger.info("Sistema iniciado");
	}
	@Bean
	
	CommandLineRunner runner(){
		return args -> {
			Cliente c1 = new Cliente("Isaac", "rua 1", "40028922", "Benfica", "606060");
			Cliente c2 = new Cliente("João", "rua 2", "40028922", "Benfica", "606061");
			Cliente c3 = new Cliente("Natan", "rua 3", "40028922", "Benfica", "606062");
			Cliente c4 = new Cliente("marcos", "rua 4", "40028922", "Benfica", "606063");
			Cliente c5 = new Cliente("Joana", "rua 5", "40028922", "Benfica", "606064");
			Cliente c6 = new Cliente("Joana", "rua 6", "40028922", "Benfica", "606064");
			
			clienteR.save(c1);
			clienteR.save(c2);
			clienteR.save(c3);
			clienteR.save(c4);
			clienteR.save(c5);
			clienteR.save(c6);
			
			Acervo a1 = new Acervo("Alice no país das maravilhas", (float)2.30, TipoAcervo.FILME, TipoClassificacao.PRATA, TipoMidia.DVD);
			Acervo a2 = new Acervo("Nightmare", (float)5, TipoAcervo.MUSICA, TipoClassificacao.BRONZE, TipoMidia.FITA);
			Acervo a3 = new Acervo("Super Mario", (float)16.50, TipoAcervo.VIDEOGAME, TipoClassificacao.OURO, TipoMidia.DVD);
			Acervo a4 = new Acervo("Lagoa Azul", (float)1.20, TipoAcervo.FILME, TipoClassificacao.LANCAMENTO, TipoMidia.DVD);
			Acervo a5 = new Acervo("Paranoid", (float)10, TipoAcervo.MUSICA, TipoClassificacao.OURO, TipoMidia.CD);
			Acervo a6 = new Acervo("ARK Survive", (float)32.75, TipoAcervo.VIDEOGAME, TipoClassificacao.LANCAMENTO, TipoMidia.DVD);
			
			acervo.save(a1);
			acervo.save(a2);
			acervo.save(a3);
			acervo.save(a4);
			acervo.save(a5);
			acervo.save(a6);
			
			Exemplar e1 = new Exemplar(new Date(), a1);
			Exemplar e2 = new Exemplar(new Date(), a1);
			Exemplar e3 = new Exemplar(new Date(), a1);
			Exemplar e4 = new Exemplar(new Date(), a2);
			Exemplar e5 = new Exemplar(new Date(), a2);
			Exemplar e6 = new Exemplar(new Date(), a2);
			Exemplar e7 = new Exemplar(new Date(), a3);
			Exemplar e8 = new Exemplar(new Date(), a3);
			Exemplar e9 = new Exemplar(new Date(), a3);
			Exemplar e10 = new Exemplar(new Date(), a4);
			Exemplar e11 = new Exemplar(new Date(), a4);
			Exemplar e12 = new Exemplar(new Date(), a4);
			Exemplar e13 = new Exemplar(new Date(), a5);
			Exemplar e14 = new Exemplar(new Date(), a5);
			Exemplar e15 = new Exemplar(new Date(), a5);
			Exemplar e16 = new Exemplar(new Date(), a6);
			Exemplar e17 = new Exemplar(new Date(), a6);
			Exemplar e18 = new Exemplar(new Date(), a6);
			
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
			
			
			Emprestimo ep1 = new Emprestimo(new Date(), c1);
			ItemEmprestimo item1 = new ItemEmprestimo (e1, ep1);
			ItemEmprestimo item2 = new ItemEmprestimo(e2, ep1);
			ItemEmprestimo item3 = new ItemEmprestimo(e3, ep1);
			ItemEmprestimo item4 = new ItemEmprestimo(e4, ep1);
			
			Emprestimo ep2 = new Emprestimo(new Date(),c2);
			ItemEmprestimo item5 = new ItemEmprestimo(e5, ep2);
			ItemEmprestimo item6 = new ItemEmprestimo(e6, ep2);
			ItemEmprestimo item7 = new ItemEmprestimo(e7, ep2);
			ItemEmprestimo item8 = new ItemEmprestimo(e8, ep2);
			
			Emprestimo ep3 = new Emprestimo(new Date(), c3);
			ItemEmprestimo item9 = new ItemEmprestimo(e9, ep3);
			ItemEmprestimo item10 = new ItemEmprestimo(e10, ep3);
			ItemEmprestimo item11 = new ItemEmprestimo(e11, ep3);
			ItemEmprestimo item12 = new ItemEmprestimo(e12, ep3);
			
			Emprestimo ep4 = new Emprestimo(new Date(), c4);
			ItemEmprestimo item13 = new ItemEmprestimo(e13, ep4);
			ItemEmprestimo item14 = new ItemEmprestimo(e14, ep4);
			ItemEmprestimo item15 = new ItemEmprestimo(e15, ep4);
			
			Emprestimo ep5 = new Emprestimo(new Date(), c5);
			ItemEmprestimo item16 = new ItemEmprestimo(e16, ep5);
			
			Emprestimo ep6 = new Emprestimo(new Date(), c6);
			ItemEmprestimo item17 = new ItemEmprestimo(e17, ep6);
			ItemEmprestimo item18 = new ItemEmprestimo(e18, ep6);
			
			emprestimo.save(ep1);
			emprestimo.save(ep2);
			emprestimo.save(ep3);
			emprestimo.save(ep4);
			emprestimo.save(ep5);
			emprestimo.save(ep6);
			
			
			itemEmprestimo.save(item1);
			itemEmprestimo.save(item2);
			itemEmprestimo.save(item3);
			itemEmprestimo.save(item4);
			itemEmprestimo.save(item5);
			itemEmprestimo.save(item6);
			itemEmprestimo.save(item7);
			itemEmprestimo.save(item8);
			itemEmprestimo.save(item9);
			itemEmprestimo.save(item10);
			itemEmprestimo.save(item11);
			itemEmprestimo.save(item12);
			itemEmprestimo.save(item13);
			itemEmprestimo.save(item14);
			itemEmprestimo.save(item15);
			itemEmprestimo.save(item16);
			itemEmprestimo.save(item17);
			itemEmprestimo.save(item18);
		};
	}

}
