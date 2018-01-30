package org.lacos.baby.modelo;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.lacos.baby.utils.BaseEntity;


@Entity
@Table(name="tb_modelo")
@AttributeOverride(name="id", column = @Column(name="pk_id") )
public class Modelo extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;



	@Column(name="tb_modelo",length = 255, nullable=false)
	private String modelo;

	@Column(name="tb_cor",length = 255, nullable=false)
	private String cor;

	@Column(name="tb_tamanho",length = 255, nullable=false)
	private String tamanho;



	@Column(name="tb_valor", length = 10,nullable=false)
	private BigDecimal valor;

	//@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] file;

	@Column(name = "mime_type", nullable = true)
	private String mimeType;




	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Modelo(String modelo, String cor, String tamanho,  BigDecimal valor, byte[] file,
			String mimeType) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.tamanho = tamanho;

		this.valor = valor;
		this.file = file;
		this.mimeType = mimeType;
	}






	public String getModelo() {
		return modelo;
	}




	public void setModelo(String modelo) {
		this.modelo = modelo;
	}




	public String getCor() {
		return cor;
	}




	public void setCor(String cor) {
		this.cor = cor;
	}




	public String getTamanho() {
		return tamanho;
	}




	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}






	public BigDecimal getValor() {
		return valor;
	}




	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}




	public byte[] getFile() {
		return file;
	}




	public void setFile(byte[] file) {
		this.file = file;
	}




	public String getMimeType() {
		return mimeType;
	}




	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}



}
