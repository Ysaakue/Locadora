package locadora.web;

class ClienteNotFoundException extends RuntimeException {
	ClienteNotFoundException(Long id) {
		super("Não foi possível encontrar o Cliente " + id);
	}
}