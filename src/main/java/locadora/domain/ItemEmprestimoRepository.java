package locadora.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import locadora.domain.ItemEmprestimo;

public interface ItemEmprestimoRepository extends CrudRepository <ItemEmprestimo, Long>{
	List<ItemEmprestimo> findByEmprestimo(@Param("emprestimo") Emprestimo emprestimo);
}
