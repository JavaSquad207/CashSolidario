package com.entra21.cashsolidario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.cashsolidario.entity.Endereco;
import com.entra21.cashsolidario.repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/endereco")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping(value = "salvarId")
	@ResponseBody
	public ResponseEntity<Endereco> salvarId(@RequestBody Endereco e) {
		Endereco endereco = enderecoRepository.save(e);
		return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
	}

	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<?> salvar(@RequestBody Endereco e) {
		Endereco endereco = enderecoRepository.save(e);
		return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
	}

	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Endereco>> listaEndereco() {
		List<Endereco> endereco = enderecoRepository.findAll();
		return new ResponseEntity<List<Endereco>>(endereco, HttpStatus.OK);
	}

	@GetMapping(value = "enderecoid/{id}")
	@ResponseBody
	public ResponseEntity<Endereco> EnderecoID(@PathVariable("id") Long id) {
		Endereco e = enderecoRepository.findById(id).get();
		return new ResponseEntity<Endereco>(e, HttpStatus.OK);
	}

	@GetMapping(value = "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Endereco id) {
		if (id.getFk_idCliente() == null) {
			Long verificarIdentidade = id.getFk_idEntidade();
			enderecoRepository.enderecoExcluiEntidade(verificarIdentidade);
		} else if (id.getFk_idEntidade() == null) {

			Long verificarCliente = id.getFk_idCliente();
			enderecoRepository.enderecoExcluiCliente(verificarCliente);

		}
		
		return new ResponseEntity<String>("Endereco Excluído com Sucesso", HttpStatus.OK);

	}

}