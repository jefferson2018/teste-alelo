	package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.models.Veiculo;
import com.example.api.service.VeiculoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Veiculo veiculo){
		try {
			veiculoService.save(veiculo);
			return new ResponseEntity<>( new ObjectMapper().writeValueAsString("Veiculo cadastrado com sucesso"),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Veiculo veiculo){
		try {
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(veiculoService.updateVeiculo(veiculo)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<String> findAll(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
					@RequestParam(value = "size", required = false, defaultValue = "10") int size){
		try {
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(veiculoService.findAll(page, size)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping("/plate/{plate}")
	public ResponseEntity<String> findByPlate(@PathVariable String plate,@RequestParam(value = "page",required = false,defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size){
		try {
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(veiculoService.findByPlate(plate, page, size)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<String> findByStatus(@PathVariable Boolean status, @RequestParam(value = "page",required = false,defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size){
		try {
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(veiculoService.findByStatus(status, page, size)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<String> findVehicle(@PathVariable Long id){
		try {
			return new ResponseEntity<>(new ObjectMapper().writeValueAsString(veiculoService.findById(id)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable Long id) throws JsonProcessingException, Exception{
		
		return new ResponseEntity<>(new ObjectMapper().writeValueAsString(veiculoService.delete(id)), HttpStatus.OK);
	}
}
