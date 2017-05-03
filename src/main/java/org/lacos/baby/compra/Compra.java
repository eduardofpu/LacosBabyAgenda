package org.lacos.baby.compra;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.lacos.baby.utils.BaseEntity;

@Entity
@Table(name = "tb_compra")
@AttributeOverride(name ="id",column = @Column(name = "pk_id"))
public class Compra extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@Column(name = "tb_dia", nullable = false, length = 20)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dia;

	@Column(name = "tb_material", nullable = false, length = 255)
	private String material;

	@Column(name = "tb_quantidade", nullable = false, length = 10)
	private Integer quantidade;

	@Column(name = "tb_preco", nullable = false, length = 10)
	private BigDecimal preco;

	@Column(name = "tb_valor", nullable = false, length = 10)
	private BigDecimal valor;



	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Compra(Date dia, String material, Integer quantidade, BigDecimal preco, BigDecimal valor) {
		super();
		this.dia = dia;
		this.material = material;
		this.quantidade = quantidade;
		this.preco = preco;
		this.valor = valor;
	}



	public Date getDia() {
		return dia;
	}



	public void setDia(Date dia) {
		this.dia = dia;
	}



	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public Integer getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	public BigDecimal getPreco() {
		return preco;
	}



	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}



	public BigDecimal getValor() {
		return valor;
	}



	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}




}
