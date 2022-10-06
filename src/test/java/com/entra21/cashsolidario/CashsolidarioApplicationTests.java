package com.entra21.cashsolidario;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.entra21.cashsolidario.controller.ClienteController;
import com.entra21.cashsolidario.entity.Cliente;
import com.entra21.cashsolidario.entity.Endereco;


@DataJpaTest
@SpringBootTest
class CashsolidarioApplicationTests {
	
	@Autowired
	private ClienteController clientecontroller;	

	@Test
	void contextLoads() {
		
		/*
		
		Endereco end = new Endereco();
		end.setLogradouro("NOME DA RUA");
		end.setNumero(800);
		end.setComplemento("COMPLEMENTO DA RUA");
		end.setBairro("BAIRRO DA RUA");
		end.setCep("83750000");
		end.setCidade("CIDADE DA RUA");
		end.setUf("SC");
		
		List<Endereco> endereco = new ArrayList();
		endereco.add(end);
		
		Cliente cli = new Cliente();
		cli.setNome("CLIENTE 01");
		cli.setCpf("12345678901");
		cli.setEndereco(endereco);
		
		clientecontroller.salvar(cli);
*/
	}

}
