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

import locadora.domain.Acervo;
import locadora.domain.AcervoRepository;

@RestController
public class AcervoController {
	@Autowired
	private AcervoRepository repository;
	
	// --INDEX--
	@GetMapping("/acervos")
	public List<Acervo> index() {
		return repository.findAll();
	}
	
	// --SHOW--
	@GetMapping("/acervos/{id}")
	Acervo show(@PathVariable long id) {
		return repository.findById(id)
				.orElseThrow(() -> new AcervoNotFoundException(id));
	}
	
	// --CREATE--
	@PostMapping("/acervos")
	Acervo create(@RequestBody Map<String, Object> acervo) {
		String titulo = (String)acervo.get("titulo");
		float valor = Float.parseFloat((String)acervo.get("valor"));
		String tipoAcervo = (String)acervo.get("tipoAcervo");
		String tipoClassificacao = (String)acervo.get("tipoClassificacao");
		String tipoMidia= (String)acervo.get("tipoMidia");
		
		Acervo newAcervo = new Acervo(titulo, valor, tipoAcervo, tipoClassificacao, tipoMidia);
		repository.save(newAcervo);
		return newAcervo;
	}
	
	@PutMapping("/acervos/{id}")
	Acervo edit(@PathVariable("id") Long id, @RequestBody Map<String, Object> putAcervo) {
		Acervo acervo = repository.findById(id)
				.orElseThrow(() -> new AcervoNotFoundException(id));

		if((String)putAcervo.get("titulo")!= null) {
			acervo.setTitulo((String)putAcervo.get("titulo"));			
		}
		if((String)putAcervo.get("valor")!= null) {
			acervo.setValor(Float.parseFloat((String)putAcervo.get("valor")));
		}
		if((String)putAcervo.get("tipoAcervo")!= null) {
			acervo.setTipoAcervo((String)putAcervo.get("tipoAcervo"));
		}
		if((String)putAcervo.get("tipoClassificacao")!= null) {
			acervo.setTipoClassificacao((String)putAcervo.get("tipoClassificacao"));
		}
		if((String)putAcervo.get("tipoMidia")!= null) {
			acervo.setTipoMidia((String)putAcervo.get("tipoMidia"));
		}
		
		repository.save(acervo);
		
		return acervo;
	}
	
	@DeleteMapping("/acervos/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
