package locadora.domain;

public enum TipoMidia {
	CD(1),DVD(2),FITA(3);
	private int opcao;

	private TipoMidia(int opcao) {
		this.opcao = opcao;
	}

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}
	
}
