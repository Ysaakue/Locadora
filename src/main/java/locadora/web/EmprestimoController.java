package locadora.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Cliente;
import locadora.domain.ClienteRepository;
import locadora.domain.Emprestimo;
import locadora.domain.EmprestimoRepository;

@RestController
public class EmprestimoController {
	@Autowired
	private EmprestimoRepository repository;
	private ClienteRepository clienteRepository;
	
	// --INDEX--
	@GetMapping("/emprestimos")
	public List<Emprestimo> index() {
		return repository.findAll();
	}
	
	// --SHOW--
	@GetMapping("/emprestimos/{id}")
	Emprestimo show(@PathVariable long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmprestimoNotFoundException(id));
	}
	
	// --CREATE--
	@PostMapping("/emprestimos")
	Emprestimo create(@RequestBody Map<String, Object> emprestimo) { 
		long clienteId = Long.parseLong((String)emprestimo.get("cliente"));
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ClienteNotFoundException(clienteId));
		
		Emprestimo newEmprestimo = new Emprestimo(new Date(), cliente);
		repository.save(newEmprestimo);
		return newEmprestimo;
	}
	
	// --EDIT--
	@PutMapping("/emprestimos/{id}")
	Emprestimo edit(@PathVariable("id") Long id, @RequestBody Map<String, Object> putEmprestimo) {
		Emprestimo emprestimo = repository.findById(id)
				.orElseThrow(() -> new EmprestimoNotFoundException(id));
		
		if((String)putEmprestimo.get("cliente") != null) {
			long clienteId = Long.parseLong((String)putEmprestimo.get("cliente"));
			Cliente cliente = clienteRepository.findById(clienteId)
					.orElseThrow(() -> new ClienteNotFoundException(clienteId));
			emprestimo.setCliente(cliente);			
		}
		
		repository.save(emprestimo);
		
		return emprestimo;
	}
	
	// --DELETE--
	@DeleteMapping("/emprestimos/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}