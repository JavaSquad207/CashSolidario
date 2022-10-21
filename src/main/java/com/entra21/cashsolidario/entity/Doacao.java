package com.entra21.cashsolidario.entity;

import java.sql.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
// @Getter
// @Setter
//@ToString
//@ToString(onlyExplicitlyIncluded = true)
//@ToString.Exclude

@Data
@Entity
public class Doacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long fkIdCliente;
	
	private Long fkIdCampanha;
	
	private Double valor;
	
	private Date dataRegistroDoacao;
		
		
}
