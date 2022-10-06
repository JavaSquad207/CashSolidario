package com.entra21.cashsolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.cashsolidario.entity.Cliente;
import com.entra21.cashsolidario.entity.Endereco;
import com.entra21.cashsolidario.repository.ClienteRepository;
import com.entra21.cashsolidario.repository.EnderecoRepository;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value="/cliente")

public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<Cliente>salvar(@RequestBody Cliente c){
		Cliente cliente = clienteRepository.save(c);
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Cliente>>listaCliente(){
		List<Cliente> cliente = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
	}

}	


