package locadora.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends CrudRepository <Cliente, Long>{
	//Fetch clients by name
	List<Cliente> findByNome(@Param("nome") String nome);

	// Fetch clients by code
	List<Cliente> findByCodigo(@Param("codigo") String codigo);
}


