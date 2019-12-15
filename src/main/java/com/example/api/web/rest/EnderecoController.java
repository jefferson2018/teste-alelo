package com.example.api.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.Endereco;
import com.example.api.service.EnderecoService;

@RestController
@RequestMapping("/adress")
public class EnderecoController {
	
	private EnderecoService service;
	
	@Autowired
	public EnderecoController(EnderecoService service) {
		this.service = service;
	}

	@PostMapping("/{idCustomer}/{cep}")
	public ResponseEntity<String> saveEndereco(@PathVariable Long idCustomer, @PathVariable String cep) {
		try {
			service.saveEndereco(idCustomer,cep);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public List<Endereco> findAll() {
		return service.findAll();

	}
	
	@DeleteMapping("/{idEndereco}")
	public ResponseEntity<String> deleteEndereco(@PathVariable Long idEndereco) {
		try {
			service.deleteEndereco(idEndereco);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
