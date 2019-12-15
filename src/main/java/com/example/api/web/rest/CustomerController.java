package com.example.api.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public Page<Customer> findAll(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
						@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		Pageable pagealbe =  PageRequest.of(page, size);
		return service.findAll(pagealbe);
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	@PostMapping
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		try {
			service.saveCustomer(customer);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
					
			} catch (Exception e) {
				return new ResponseEntity<String>("Error to Save Customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	@PutMapping
	public ResponseEntity<String> editCustomer(@RequestBody Customer customer) {
		try {
			service.saveCustomer(customer);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
					
			} catch (Exception e) {
				return new ResponseEntity<String>("Error to Edit Customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		try {
			service.deleteCustomer(id);
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
					
			} catch (Exception e) {
				return new ResponseEntity<String>("Error to Delete Customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}

}
