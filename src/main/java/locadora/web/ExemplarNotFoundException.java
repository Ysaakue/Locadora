package locadora.web;

 class ExemplarNotFoundException extends RuntimeException {
	ExemplarNotFoundException(Long id) {
		super("Não foi possível encontrar o Acervo " + id);
	}
}
