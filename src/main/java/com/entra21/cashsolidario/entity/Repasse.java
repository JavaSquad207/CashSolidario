package com.entra21.cashsolidario.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Repasse implements Serializable {
		private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRepasse;
	private int fk_idCampanha;
	private float valor;
	private Date dataRepasse;
	
	public Repasse() {
		super();		
	}

	public Repasse(Long idRepasse, int fk_idCampanha, float valor, Date dataRepasse) {
		super();
		this.idRepasse = idRepasse;
		this.fk_idCampanha = fk_idCampanha;
		this.valor = valor;
		this.dataRepasse = dataRepasse;
	}

	public Long getIdRepasse() {
		return idRepasse;
	}

	public void setIdRepasse(Long idRepasse) {
		this.idRepasse = idRepasse;
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

	public Date getDataRepasse() {
		return dataRepasse;
	}

	public void setDataRepasse(Date dataRepasse) {
		this.dataRepasse = dataRepasse;
	}

	@Override
	public String toString() {
		return "Repasse [idRepasse=" + idRepasse + ", fk_idCampanha=" + fk_idCampanha + ", valor=" + valor
				+ ", dataRepasse=" + dataRepasse + "]";
	}
	

}
