package locadora.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ItemEmprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exemplar")
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Exemplar exemplar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emprestimo")
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Emprestimo emprestimo;

	public ItemEmprestimo() {}
	
	public ItemEmprestimo(Exemplar exemplar, Emprestimo emprestimo) {
		super();
		this.exemplar = exemplar;
		this.emprestimo = emprestimo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public long getId() {
		return id;
	}
	 public float calcularValor() {
		 this.valor = this.getExemplar().getAcervo().getValor();
		 return this.valor;
	 }
}
