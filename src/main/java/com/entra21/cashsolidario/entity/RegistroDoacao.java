package com.entra21.cashsolidario.entity;

import java.util.Date;

public class RegistroDoacao {

	private int idRegistroDoacao;
	private int fk_idCliente;
	private int fk_idCampanha;
	private float valor;
	private Date dataRegistroDoacao;

	public RegistroDoacao() {
		super();
	}

	public RegistroDoacao(int idRegistroDoacao, int fk_idCliente, int fk_idCampanha, float valor,
			Date dataRegistroDoacao) {
		super();
		this.idRegistroDoacao = idRegistroDoacao;
		this.fk_idCliente = fk_idCliente;
		this.fk_idCampanha = fk_idCampanha;
		this.valor = valor;
		this.dataRegistroDoacao = dataRegistroDoacao;
	}

	public int getIdRegistroDoacao() {
		return idRegistroDoacao;
	}

	public void setIdRegistroDoacao(int idRegistroDoacao) {
		this.idRegistroDoacao = idRegistroDoacao;
	}

	public int getFk_idCliente() {
		return fk_idCliente;
	}

	public void setFk_idCliente(int fk_idCliente) {
		this.fk_idCliente = fk_idCliente;
	}

	public int getFk_idCampanha() {
		return fk_idCampanha;
	}

	public void setFk_idCampanha(int fk_idCampanha) {
		this.fk_idCampanha = fk_idCampanha;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getDataRegistroDoacao() {
		return dataRegistroDoacao;
	}

	public void setDataRegistroDoacao(Date dataRegistroDoacao) {
		this.dataRegistroDoacao = dataRegistroDoacao;
	}

	@Override
	public String toString() {
		return "RegistroDoacao [idRegistroDoacao=" + idRegistroDoacao + ", fk_idCliente=" + fk_idCliente
				+ ", fk_idCampanha=" + fk_idCampanha + ", valor=" + valor + ", dataRegistroDoacao=" + dataRegistroDoacao
				+ "]";
	}

}
