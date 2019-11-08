package locadora.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exemplar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int sequencial;
	private Date dataRegistro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acervo")
	private Acervo acervo;

	public Exemplar() {}
	
	public Exemplar(int sequencial, Date dataRegistro, Acervo acervo) {
		super();
		this.sequencial = sequencial;
		this.dataRegistro = dataRegistro;
		this.acervo = acervo;
	}

	public int getSequencial() {
		return sequencial;
	}

	public void setSequencial(int sequencial) {
		this.sequencial = sequencial;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Acervo getAcervo() {
		return acervo;
	}

	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}
	public long getId() {
		return id;
	}
}
