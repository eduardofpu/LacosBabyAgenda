package org.lacos.baby.clientes;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.lacos.baby.pedido.Pedidos;
import org.lacos.baby.utils.BaseEntity;

@Entity
@Table(name="tb_clientes")
@AttributeOverride(name="id", column = @Column(name="pk_id") )
public class Clientes extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;


	@Column(name="tb_nome",length = 255, nullable=false)
	private String nome;

	@Column(name="tb_telefone",length = 120, nullable=false , unique=true)
	private String telefone;

	@Column(name="tb_endereco",length = 255, nullable=false)
	private String endereco;

	@Column(name="tb_numero",length = 10, nullable=false)
	private String numero;

	@Column(name="tb_bairro",length = 255, nullable=false)
	private String bairro;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientes")
	private List<Pedidos> pedido;

	public Clientes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clientes(String nome, String telefone, String endereco, String numero, String bairro) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
	}







	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


}
