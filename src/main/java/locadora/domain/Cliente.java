package locadora.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome, endereco, telefone, bairro, cep;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	@JsonManagedReference
	private List<Emprestimo> emprestimos;
	
	public Cliente() {}
	
	public Cliente(String nome, String endereco, String telefone, String bairro, String cep) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.bairro = bairro;
		this.cep = cep;
		this.emprestimos = new LinkedList<Emprestimo>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public long getId() {
		return id;
	}
}
