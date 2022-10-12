package com.entra21.cashsolidario.regra;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RegistroDoacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int fkIdCliente;
	private int fkIidCampanha;
	private Double valor;
	private String dataRegistroDoacao;
	
}
