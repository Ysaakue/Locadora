package locadora.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Acervo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codigo, titulo;
	private float valor;
	private TipoAcervo tipoAcervo;
	private TipoClassificacao tipoClassificacao;
	private TipoMidia tipoMidia;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "acervo")
	private List<Exemplar> exemplares;

	public Acervo() {}
	
	public Acervo(String codigo, String titulo, float valor, TipoAcervo tipoAcervo, TipoClassificacao tipoClassificacao,
			TipoMidia tipoMidia) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.valor = valor;
		this.tipoAcervo = tipoAcervo;
		this.tipoClassificacao = tipoClassificacao;
		this.tipoMidia = tipoMidia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public TipoAcervo getTipoAcervo() {
		return tipoAcervo;
	}

	public void setTipoAcervo(TipoAcervo tipoAcervo) {
		this.tipoAcervo = tipoAcervo;
	}

	public TipoClassificacao getTipoClassificacao() {
		return tipoClassificacao;
	}

	public void setTipoClassificacao(TipoClassificacao tipoClassificacao) {
		this.tipoClassificacao = tipoClassificacao;
	}

	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoMidia tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public List<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
	
	public void addExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar);
	}
	
	public long getId() {
		return id;
	}
	
}
