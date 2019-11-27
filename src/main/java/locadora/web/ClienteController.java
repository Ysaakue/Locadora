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

import locadora.domain.Cliente;
import locadora.domain.ClienteRepository;

@RestController
public class ClienteController {
	@Autowired
	private ClienteRepository repository;

	// --INDEX--
	@GetMapping("/clientes")
	public List<Cliente> getAcervos() {
		return repository.findAll();
	}
	
	// --SHOW--
	@GetMapping("/clientes/{id}")
	Cliente one(@PathVariable long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
	}
	
	// --CREATE--
	@PostMapping("/clientes")
	Cliente post(@RequestBody Map<String, Object> cliente) { 
		String nome = (String)cliente.get("nome");
		String endereco = (String)cliente.get("endereco");
		String telefone = (String)cliente.get("telefone");
		String bairro = (String)cliente.get("bairro");
		String cep = (String)cliente.get("cep");
		
		Cliente newCliente = new Cliente(nome, endereco, telefone, bairro, cep);
		repository.save(newCliente);
		return newCliente;
	}
	
	@PutMapping("/clientes/{id}")
	Cliente put(@PathVariable("id") Long id, @RequestBody Map<String, Object> putCliente) {
		Cliente cliente = repository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException(id));
		if((String)putCliente.get("nome") != null) {
			cliente.setNome((String)putCliente.get("nome"));			
		}
		if((String)putCliente.get("endereco") != null) {
			cliente.setEndereco((String)putCliente.get("endereco"));			
		}
		if((String)putCliente.get("telefone") != null) {
			cliente.setEndereco((String)putCliente.get("telefone"));			
		}
		if((String)putCliente.get("bairro") != null) {
			cliente.setBairro((String)putCliente.get("bairro"));			
		}
		if((String)putCliente.get("cep") != null) {
			cliente.setCep((String)putCliente.get("cep"));			
		}
		
		repository.save(cliente);
		
		return cliente;
	}
	
	@DeleteMapping("/clientes/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}