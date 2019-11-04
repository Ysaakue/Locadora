package locadora.domain;

public enum TipoAcervo {
	FILME(1),VIDEOGAME(2),MUSICA(3);
	private int opcao;

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	private TipoAcervo(int opcao) {
		this.opcao = opcao;
	}
}
