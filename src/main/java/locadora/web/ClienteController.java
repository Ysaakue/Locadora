package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Cliente;
import locadora.domain.ClienteRepository;

@RestController
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@RequestMapping("/clientes")
	public Iterable<Cliente> getClientes() {
		return repository.findAll();
	}

}
