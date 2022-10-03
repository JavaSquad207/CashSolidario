package com.entra21.cashsolidario.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="fk_idCliente")
	private Cliente cliente;
	// private int fk_idCliente;
	@ManyToOne
	@JoinColumn(name="fk_idEntidade")
	private Entidade entidade;
	// private int fk_idEntidade;
	private String cep;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;

	public Endereco() {
		super();
	}

	public Endereco(Long id, int fk_idCliente, int fk_idEntidade, String cep, String logradouro, int numero,
			String complemento, String bairro, String cidade, String uf) {
		super();
		this.id = id;
		this.fk_idCliente = fk_idCliente;
		this.fk_idEntidade = fk_idEntidade;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFk_idCliente() {
		return fk_idCliente;
	}

	public void setFk_idCliente(int fk_idCliente) {
		this.fk_idCliente = fk_idCliente;
	}

	public int getFk_idEntidade() {
		return fk_idEntidade;
	}

	public void setFk_idEntidade(int fk_idEntidade) {
		this.fk_idEntidade = fk_idEntidade;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", fk_idCliente=" + fk_idCliente + ", fk_idEntidade=" + fk_idEntidade + ", cep="
				+ cep + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + "]";
	}

}
