package locadora.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Acervo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String titulo;
	private float valor;
	private TipoAcervo tipoAcervo;
	private TipoClassificacao tipoClassificacao;
	private TipoMidia tipoMidia;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "acervo")
	@JsonManagedReference
	private List<Exemplar> exemplares;

	public Acervo() {}
	
	public Acervo(String titulo, float valor, TipoAcervo tipoAcervo, TipoClassificacao tipoClassificacao, TipoMidia tipoMidia) {
		super();
		this.titulo = titulo;
		this.valor = valor;
		this.tipoAcervo = tipoAcervo;
		this.tipoClassificacao = tipoClassificacao;
		this.tipoMidia = tipoMidia;
	}
	
	public Acervo(String titulo, float valor, String tipoAcervo, String tipoClassificacao, String tipoMidia) {
		super();
		this.titulo = titulo;
		this.valor = valor;
		
		if(tipoAcervo.equals("Filme")) {
			this.tipoAcervo = TipoAcervo.FILME;
		} else if(tipoAcervo.equals("VideoGame")) {
			this.tipoAcervo = TipoAcervo.VIDEOGAME;
		} else {
			this.tipoAcervo = TipoAcervo.MUSICA;
		}
		if(tipoClassificacao.equals("Ouro")) {
			this.tipoClassificacao = TipoClassificacao.OURO;
		} else if(tipoClassificacao.equals("Prata")) {
			this.tipoClassificacao = TipoClassificacao.PRATA;
		} else if(tipoClassificacao.equals("Bronze")) {
			this.tipoClassificacao = TipoClassificacao.BRONZE;
		} else {
			this.tipoClassificacao = TipoClassificacao.LANCAMENTO;
		}
		if(tipoAcervo.equals("Cd")) {
			this.tipoMidia = TipoMidia.CD;
		} else if(tipoMidia.equals("Dvd")) {
			this.tipoMidia = TipoMidia.DVD;
		} else {
			this.tipoMidia = TipoMidia.FITA;
		}
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
	
	
	public void setTipoAcervo(String tipoAcervo) {
		if(tipoAcervo.equals("Filme")) {
			this.tipoAcervo = TipoAcervo.FILME;
		} else if(tipoAcervo.equals("VideoGame")) {
			this.tipoAcervo = TipoAcervo.VIDEOGAME;
		} else {
			this.tipoAcervo = TipoAcervo.MUSICA;
		}
	}

	public TipoClassificacao getTipoClassificacao() {
		return tipoClassificacao;
	}

	public void setTipoClassificacao(TipoClassificacao tipoClassificacao) {
		this.tipoClassificacao = tipoClassificacao;
	}

	public void setTipoClassificacao(String tipoClassificacao) {
		if(tipoClassificacao.equals("Ouro")) {
			this.tipoClassificacao = TipoClassificacao.OURO;
		} else if(tipoClassificacao.equals("Prata")) {
			this.tipoClassificacao = TipoClassificacao.PRATA;
		} else if(tipoClassificacao.equals("Bronze")) {
			this.tipoClassificacao = TipoClassificacao.BRONZE;
		} else {
			this.tipoClassificacao = TipoClassificacao.LANCAMENTO;
		}
	}
	
	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoMidia tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	
	public void setTipoMidia(String tipoMidia) {
		if(tipoAcervo.equals("Cd")) {
			this.tipoMidia = TipoMidia.CD;
		} else if(tipoMidia.equals("Dvd")) {
			this.tipoMidia = TipoMidia.DVD;
		} else {
			this.tipoMidia = TipoMidia.FITA;
		}
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
	
	public void setId(long id) {
		this.id = id;
	}
}
