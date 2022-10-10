package com.entra21.cashsolidario.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name= "endereco_seq", sequenceName = "endereco_seq", initialValue = 1, allocationSize = 1)
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
	private Long id;
	private String cep;
	
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	// @OneToOne(cascade = CascadeType.ALL)
	
	// private Cliente client;

	
	
	public Endereco() {
		super();
	}


	public Endereco(Long id, String cep, String logradouro, int numero, String complemento, String bairro,
			String cidade, String uf, Cliente client) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		// this.client = client;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}

/*
	public Cliente getClient() {
		return client;
	}


	public void setClient(Cliente client) {
		this.client = client;
	}
	
*/
	
	
}