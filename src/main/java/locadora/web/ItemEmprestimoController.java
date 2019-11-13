package locadora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import locadora.domain.ItemEmprestimoRepository;

@RestController
public class ItemEmprestimoController {
	@Autowired
	private ItemEmprestimoRepository repository;
	
}

