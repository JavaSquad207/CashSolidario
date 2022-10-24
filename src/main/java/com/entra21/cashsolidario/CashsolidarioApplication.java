package com.entra21.cashsolidario;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashsolidarioApplication {
	
	

	
		public static void main(String[] args) {
		SpringApplication.run(CashsolidarioApplication.class, args);
		Locale.setDefault(new Locale("pt", "BR"));
		TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
		TimeZone.setDefault(tz);
		
		
		

	}

}
