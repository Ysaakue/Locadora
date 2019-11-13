package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import locadora.domain.Acervo;
import locadora.domain.AcervoRepository;

@RestController
public class AcervoController {
	@Autowired
	private AcervoRepository repository;
	
	@RequestMapping(value="/acervos", method=RequestMethod.GET)
	public Iterable<Acervo> getAcervos() {
		return repository.findAll();
		}
	@RequestMapping(value= "/acervos/", method=RequestMethod.DELETE)
	public String excluir(Acervo acervo) {
		repository.delete(acervo);
		return "Acervo deletado";
	}
	
}
