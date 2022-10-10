package com.entra21.cashsolidario.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Campanha implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCampanha;
	private int fk_Identidade;
	private String nome;
	private Date dataInicio;
	private Date dataFinal;
	
	public Campanha() {
		super();
	}

	public Campanha(Long idCampanha, int fk_Identidade, String nome, Date dataInicio, Date dataFinal) {
		super();
		this.idCampanha = idCampanha;
		this.fk_Identidade = fk_Identidade;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public Long getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}

	public int getFk_Identidade() {
		return fk_Identidade;
	}

	public void setFk_Identidade(int fk_Identidade) {
		this.fk_Identidade = fk_Identidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public String toString() {
		return "Campanha [idCampanha=" + idCampanha + ", fk_Identidade=" + fk_Identidade + ", nome=" + nome
				+ ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + "]";
	}
	
	
}
