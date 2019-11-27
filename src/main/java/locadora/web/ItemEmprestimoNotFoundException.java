package locadora.web;

public class ItemEmprestimoNotFoundException extends RuntimeException {
	ItemEmprestimoNotFoundException(Long id) {
		super("Não foi possível encontrar o Item Emprestimo" + id);
	}
}