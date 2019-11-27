package locadora.web;

class AcervoNotFoundException extends RuntimeException {
	  AcervoNotFoundException(Long id) {
		  super("Não foi possível encontrar o Acervo " + id);
	  }
}
