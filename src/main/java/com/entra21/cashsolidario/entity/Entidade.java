package com.entra21.cashsolidario.entity;

public class Entidade {
		
	private Long id;
	private String nome;
	private String cnpj;
	
	
	public Entidade() {
		super();
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


	public Entidade(Long id, String nome, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	
	
	
	
}
