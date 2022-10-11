package com.entra21.cashsolidario.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entidade implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cnpj;
	
	


	public Entidade() {
		super();
	}


	public Entidade(Long id, String nome, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	


	@Override
	public String toString() {
		return "Entidade [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + "]";
	}
	
	
	
	
	
	
	
}
