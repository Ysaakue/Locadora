package locadora.domain;

import java.sql.Date;
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

@Entity
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codigo;
	private Date dataEmprestimo, dataEntregaPrevista, dataEntrega;
	private float valorEmprestimo, valorMulta, valorTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emprestimo")
	private List<ItemEmprestimo> itens;

	public Emprestimo() {}
	
	public Emprestimo(String codigo, Date dataEmprestimo, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.dataEmprestimo = dataEmprestimo;
		this.cliente = cliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return valorEmprestimo;
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
	
	public void addItem(ItemEmprestimo item) {
		this.itens.add(item);
	}
	public long getId() {
		return id;
	}
}
