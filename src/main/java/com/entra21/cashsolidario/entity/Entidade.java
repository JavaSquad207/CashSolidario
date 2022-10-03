package com.entra21.cashsolidario.entity;

public class Entidade {
	private int ID_identidade ;
	private String nome;
	private String cnpj;
	

	public Entidade(int iD_identidade, String nome, String cnpj) {
		super();
		ID_identidade = iD_identidade;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public int getID_identidade() {
		return ID_identidade;
	}
	public void setID_identidade(int iD_identidade) {
		ID_identidade = iD_identidade;
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
		return "entidade [ID_identidade=" + ID_identidade + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", getID_identidade()=" + getID_identidade() + ", getNome()=" + getNome() + ", getCnpj()=" + getCnpj()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
