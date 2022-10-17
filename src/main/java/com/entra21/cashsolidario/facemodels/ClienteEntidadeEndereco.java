package com.entra21.cashsolidario.facemodels;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class ClienteEntidadeEndereco {
	private Long id;
	private String nome;
	private String cpf;
	private String cnpj;
	private String cep;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private Long fk_idEntidade;
	private Long fk_idCliente;
	private Long endId;
	

}
