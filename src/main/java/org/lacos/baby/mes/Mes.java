package org.lacos.baby.mes;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.lacos.baby.utils.BaseEntity;
@Entity
@Table(name = "tb_mes")
@AttributeOverride(name = "id", column = @Column(name ="pk_id"))
public class Mes extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@Column(name = "tb_mes", nullable = false, length = 20)
	private String mes;

	@Column(name = "tb_valor", nullable = false, length = 10)
	private BigDecimal valor;
	public Mes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mes(String mes, BigDecimal valor) {
		super();
		this.mes = mes;
		this.valor = valor;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}



}
