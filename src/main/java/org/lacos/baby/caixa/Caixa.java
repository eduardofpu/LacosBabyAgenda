package org.lacos.baby.caixa;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.lacos.baby.utils.BaseEntity;
@Entity
@Table(name = "tb_caixa")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Caixa extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	@Column(name ="tb_total", nullable = false, length = 10)
	private BigDecimal total;



	public Caixa() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Caixa(BigDecimal total) {
		super();
		this.total = total;
	}



	public BigDecimal getTotal() {
		return total;
	}



	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public void subtrairValor(BigDecimal total){
		this.total = this.total.subtract(total);
	}


	public void adicionarValor(BigDecimal total){
		this.total = this.total.add(total);

	}

}
