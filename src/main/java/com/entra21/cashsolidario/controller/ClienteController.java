package com.entra21.cashsolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.cashsolidario.entity.Cliente;
import com.entra21.cashsolidario.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente c) {
		Cliente cliente = clienteRepository.save(c);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}

	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaCliente() {
		List<Cliente> cliente = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
	}

	//@DeleteMapping(value = "delete/{id}")
	// @ResponseBody
	//@ResponseStatus(HttpStatus.NO_CONTENT	)
	@GetMapping(value = "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Cliente id) {
		clienteRepository.delete(id);
		return new ResponseEntity<String>("Cliente Excluído com Sucesso", HttpStatus.OK);

	}

	@GetMapping(value = "clienteid")
	@ResponseBody
	public ResponseEntity<Cliente> ClienteID(@PathVariable("id") Long id) {
		Cliente c = clienteRepository.findById(id).get();
		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
	}

	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente c) {
		Cliente cliente = clienteRepository.saveAndFlush(c);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@GetMapping(value = "atualizarGen")
	@ResponseBody
	public ResponseEntity<?> atualizarGen(@RequestBody Cliente c) {
		if (c.getId() == null) {
			return new ResponseEntity<String>("Registro Inválido", HttpStatus.OK);
		}
		Cliente cliente = clienteRepository.saveAndFlush(c);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

}
