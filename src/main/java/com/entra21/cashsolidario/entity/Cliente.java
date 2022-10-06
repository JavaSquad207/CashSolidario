package com.entra21.cashsolidario.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@SuppressWarnings("unused")
public class Cliente implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String cpf;
	
	public Cliente() {
		super();
	}

	public Cliente(Long id, String name, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", cpf=" + cpf + "]";
	}
	
	
	
	
	
	
	
	
	

}
