package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Exemplar;
import locadora.domain.ExemplarRepository;;

@RestController
public class ExemplarController {
	@Autowired
	private ExemplarRepository repository;
	
	@RequestMapping(value="/exemplares", method=RequestMethod.GET)
	public Iterable<Exemplar> getExemplar(){
		return repository.findAll();
	}
	
	@RequestMapping(value= "/exemplares/", method=RequestMethod.DELETE)
	public String excluir(Exemplar exemplar) {
		repository.delete(exemplar);
		return "Exemplar excluido";

}
}