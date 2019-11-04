package locadora.domain;

public enum TipoClassificacao {
	LANCAMENTO(1),OURO(2),PRATA(3),BRONZE(4);
	private int opcao;

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	private TipoClassificacao(int opcao) {
		this.opcao = opcao;
	}
}
