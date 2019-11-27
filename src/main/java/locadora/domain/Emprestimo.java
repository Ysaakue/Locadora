package locadora.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date dataEmprestimo, dataEntregaPrevista, dataEntrega;
	private float valorEmprestimo, valorMulta, valorTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente")
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emprestimo")
	@JsonBackReference
	private List<ItemEmprestimo> itens;
	
	public Emprestimo() {}
	
	public Emprestimo(Date dataEmprestimo, Cliente cliente) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.cliente = cliente;
		this.itens = new LinkedList<ItemEmprestimo>();
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataEntregaPrevista() {
		return dataEntregaPrevista;
	}

	public void setDataEntregaPrevista(Date dataEntregaPrevista) {
		this.dataEntregaPrevista = dataEntregaPrevista;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public float getValorEmprestimo() {
		this.valorEmprestimo = 0;
		for(ItemEmprestimo item: this.itens) {
			this.valorEmprestimo+=item.calcularValor();
		}
		return this.valorEmprestimo;
	}

	public void setValorEmprestimo(float valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public float getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(float valorMulta) {
		this.valorMulta = valorMulta;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemEmprestimo> getItens() {
		return itens;
	}

	public void setItens(List<ItemEmprestimo> itens) {
		this.itens = itens;
	}
	
	public long getId() {
		return id;
	}
}
