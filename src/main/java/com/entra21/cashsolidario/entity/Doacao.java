package com.entra21.cashsolidario.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Doacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int fkIdCliente;
	private int fkIdCampanha;
	private Double valor;	
	private String dataRegistroDoacao;
		
	public Doacao() {
		super();
	}

	public Doacao(Long id, int fkIdCliente, int fkIdCampanha, Double valor, String dataRegistroDoacao) {
		super();
		this.id = id;
		this.fkIdCliente = fkIdCliente;
		this.fkIdCampanha = fkIdCampanha;
		this.valor = valor;
		this.dataRegistroDoacao = dataRegistroDoacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFkIdCliente() {
		return fkIdCliente;
	}

	public void setFkIdCliente(int fkIdCliente) {
		this.fkIdCliente = fkIdCliente;
	}

	public int getFkIdCampanha() {
		return fkIdCampanha;
	}

	public void setFkIdCampanha(int fkIdCampanha) {
		this.fkIdCampanha = fkIdCampanha;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDataRegistroDoacao() {
		return dataRegistroDoacao;
	}

	public void setDataRegistroDoacao(String dataRegistroDoacao) {
		this.dataRegistroDoacao = dataRegistroDoacao;
	}

	@Override
	public String toString() {
		return "Doacao [id=" + id + ", fkIdCliente=" + fkIdCliente + ", fkIdCampanha=" + fkIdCampanha + ", valor="
				+ valor + ", dataRegistroDoacao=" + dataRegistroDoacao + "]";
	}
	
	
}
