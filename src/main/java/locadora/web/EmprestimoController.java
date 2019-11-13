package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Emprestimo;
import locadora.domain.EmprestimoRepository;

@RestController
public class EmprestimoController {
	@Autowired
	private EmprestimoRepository repository;
	
	@RequestMapping("/emprestimos")
	public Iterable<Emprestimo> getCliente(){
		return repository.findAll();
	}
	
	@RequestMapping(value= "/emprestimos/", method=RequestMethod.DELETE)
	public String excluir(Emprestimo emprestimo) {
		repository.delete(emprestimo);
		return "Emprestimo deletado";

}
}