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

import locadora.domain.Acervo;
import locadora.domain.AcervoRepository;
import locadora.domain.Exemplar;
import locadora.domain.ExemplarRepository;;

@RestController
public class ExemplarController {
	@Autowired
	private ExemplarRepository repository;
	@Autowired
	private AcervoRepository acervoRepository;
	
	// --INDEX--
	@GetMapping("/exemplares")
	public List<Exemplar> index() {
		return repository.findAll();
	}
	
	// --SHOW--
	@GetMapping("/exemplares/{id}")
	Exemplar show(@PathVariable long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ExemplarNotFoundException(id));
	}
	
	// --CREATE--
	@PostMapping("/exemplares")
	Exemplar create(@RequestBody Map<String, Object> exemplar) { 
		long acervoId = Long.parseLong((String)exemplar.get("acervo"));
		Acervo acervo = acervoRepository.findById(acervoId)
				.orElseThrow(() -> new AcervoNotFoundException(acervoId));
		
		Exemplar newExemplar = new Exemplar(new Date(), acervo);
		repository.save(newExemplar);
		return newExemplar;
	}
	
	// --EDIT--
	@PutMapping("/exemplares/{id}")
	Exemplar edit(@PathVariable("id") Long id, @RequestBody Map<String, Object> putExemplar) {
		Exemplar exemplar = repository.findById(id)
				.orElseThrow(() -> new ExemplarNotFoundException(id));
		
		if((String)putExemplar.get("acervo") != null) {
			long acervoId = Long.parseLong((String)putExemplar.get("acervo"));
			Acervo acervo= acervoRepository.findById(acervoId)
					.orElseThrow(() -> new AcervoNotFoundException(acervoId));
			exemplar.setAcervo(acervo);			
		}
		
		repository.save(exemplar);
		
		return exemplar;
	}
	
	// --DELETE--
	@DeleteMapping("/exemplares/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}