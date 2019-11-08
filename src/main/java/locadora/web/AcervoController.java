package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Acervo;
import locadora.domain.AcervoRepository;

@RestController
public class AcervoController {
	@Autowired
	private AcervoRepository repository;
	
	@RequestMapping("/acervos")
	public Iterable<Acervo> getAcervoss() {
		return repository.findAll();
	}
}
