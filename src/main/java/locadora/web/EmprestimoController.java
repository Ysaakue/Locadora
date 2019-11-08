package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Emprestimo;
import locadora.domain.EmprestimoRepository;

@RestController
public class EmprestimoController {
	@Autowired
	private EmprestimoRepository repository;
	
	@RequestMapping("/Emprestimos")
	public Iterable<Emprestimo> getCliente(){
		return repository.findAll();
	}

}
