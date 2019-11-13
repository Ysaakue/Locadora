package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.Cliente;
import locadora.domain.ClienteRepository;

@RestController
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@RequestMapping(value = "/clientes", method=RequestMethod.GET)
	public Iterable<Cliente> getClientes() {
		return repository.findAll();
	}
	
	@RequestMapping(value= "/clientes/", method=RequestMethod.DELETE)
	public String excluir(Cliente cliente) {
		repository.delete(cliente);
		return "Cliente Deletado";
	}
}