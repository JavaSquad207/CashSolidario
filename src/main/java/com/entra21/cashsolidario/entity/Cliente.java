package com.entra21.cashsolidario.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq",
		initialValue = 1, allocationSize = 1)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	private Long id;
	private String nome;
	private String cpf;
	
	// private List<Endereco> endereco;
	
		
	public Cliente() {
		super();
	}


	public Cliente(Long id, String nome, String cpf, List<Endereco> endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	//	this.endereco = endereco;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

/*
	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

*/



		
}
