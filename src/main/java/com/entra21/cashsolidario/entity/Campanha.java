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
	private Long id;
	private int fkIdentidade;
	private String nome;
	private String dataInicio;
	private String dataFinal;
	
	public Campanha() {
		super();
	}

	public Campanha(Long id, int fkIdentidade, String nome, String dataInicio, String dataFinal) {
		super();
		this.id = id;
		this.fkIdentidade = fkIdentidade;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFkIdentidade() {
		return fkIdentidade;
	}

	public void setFkIdentidade(int fkIdentidade) {
		this.fkIdentidade = fkIdentidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public String toString() {
		return "Campanha [id=" + id + ", fkIdentidade=" + fkIdentidade + ", nome=" + nome + ", dataInicio=" + dataInicio
				+ ", dataFinal=" + dataFinal + "]";
	}

	
	
	
}
