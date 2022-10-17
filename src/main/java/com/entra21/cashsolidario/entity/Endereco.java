package com.entra21.cashsolidario.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
	
@Data
@Entity

public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private Long fk_idEntidade;
	private Long fk_idCliente;
	
}