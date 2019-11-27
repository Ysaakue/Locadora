package locadora.web;

 class EmprestimoNotFoundException extends RuntimeException {
	EmprestimoNotFoundException(Long id) {
		super("Não foi possível encontrar o Acervo " + id);
	}
}