package locadora.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Exemplar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date dataRegistro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acervo")
//	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Acervo acervo;

	public Exemplar() {}
	
	public Exemplar( Date dataRegistro, Acervo acervo) {
		super();
		this.dataRegistro = dataRegistro;
		this.acervo = acervo;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public long getAcervo() {
		return acervo.getId();
	}

	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}
	public long getId() {
		return id;
	}
}
