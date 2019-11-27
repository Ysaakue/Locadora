package locadora.web;

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

import locadora.domain.Emprestimo;
import locadora.domain.EmprestimoRepository;
import locadora.domain.Exemplar;
import locadora.domain.ExemplarRepository;
import locadora.domain.ItemEmprestimo;
import locadora.domain.ItemEmprestimoRepository;

@RestController
public class ItemEmprestimoController {
	@Autowired
	private ItemEmprestimoRepository repository;
	@Autowired
	private ExemplarRepository exemplarRepository;
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	// --INDEX--
		@GetMapping("/itens")
		public List<ItemEmprestimo> index() {
			return repository.findAll();
		}
		
		// --SHOW--
		@GetMapping("/itens/{id}")
		ItemEmprestimo show(@PathVariable long id) {
			return repository.findById(id)
					.orElseThrow(() -> new ItemEmprestimoNotFoundException(id));
		}
		
		// --CREATE--
		@PostMapping("/itens")
		ItemEmprestimo create(@RequestBody Map<String, Object> item) { 
			long exemplarId = Long.parseLong((String)item.get("exemplar"));
			Exemplar exemplar = exemplarRepository.findById(exemplarId)
					.orElseThrow(() -> new AcervoNotFoundException(exemplarId));
			long emprestimoId = Long.parseLong((String)item.get("emprestimo"));
			Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
					.orElseThrow(() -> new EmprestimoNotFoundException(emprestimoId));
			
			ItemEmprestimo newItem = new ItemEmprestimo(exemplar, emprestimo);
			repository.save(newItem);
			return newItem;
		}
		
		// --EDIT--
		@PutMapping("/itens/{id}")
		ItemEmprestimo edit(@PathVariable("id") Long id, @RequestBody Map<String, Object> putItem) {
			ItemEmprestimo item = repository.findById(id)
					.orElseThrow(() -> new ItemEmprestimoNotFoundException(id));
			
			if((String)putItem.get("exemplar") != null) {
				long exemplarId = Long.parseLong((String)putItem.get("exemplar"));
				Exemplar exemplar = exemplarRepository.findById(exemplarId)
						.orElseThrow(() -> new AcervoNotFoundException(exemplarId));
				item.setExemplar(exemplar);		
			}
			if((String)putItem.get("emprestimo") != null) {
				long emprestimoId = Long.parseLong((String)putItem.get("emprestimo"));
				Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
						.orElseThrow(() -> new EmprestimoNotFoundException(emprestimoId));
				item.setEmprestimo(emprestimo);			
			}
			
			repository.save(item);
			
			return item;
		}
		
		// --DELETE--
		@DeleteMapping("/itens/{id}")
		void delete(@PathVariable Long id) {
			repository.deleteById(id);
		}
}

