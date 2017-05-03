package org.lacos.baby.pedido;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.lacos.baby.clientes.Clientes;
import org.lacos.baby.utils.BaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_pedido")
@AttributeOverride(name="id", column = @Column(name="pk_id"))
public class Pedidos extends BaseEntity<Long>{


	private static final long serialVersionUID = 1L;



	@Column(name = "tb_descricao", length = 500, nullable = false)
	private String descricao;

	@Column(name="tb_total", length = 10,nullable=false)
	private BigDecimal valorTotal;

	@Column(name = "register_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	@Column(name = "tb_data_entrega",length = 19, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataEntrega;


	@ManyToOne
	@JoinColumn(name = "id_clientes")
	private Clientes clientes;


	public Pedidos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedidos(String descricao, BigDecimal valorTotal, Date registerDate, Date dataEntrega, Clientes clientes) {
		super();
		this.descricao = descricao;
		this.valorTotal = valorTotal;
		this.registerDate = registerDate;
		this.dataEntrega = dataEntrega;
		this.clientes = clientes;
	}







	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public BigDecimal getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	public Date getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}


	public Clientes getClientes() {
		return clientes;
	}


	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
}
