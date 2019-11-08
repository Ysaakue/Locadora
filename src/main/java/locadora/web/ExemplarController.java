package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Exemplar;
import locadora.domain.ExemplarRepository;;

@RestController
public class ExemplarController {
	@Autowired
	private ExemplarRepository repository;
	
	public Iterable<Exemplar> getExemplar(){
		return repository.findAll();
	}

}
