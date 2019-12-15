package com.example.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;


@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public Page<Customer> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public void saveCustomer(Customer customer) {
		if(customer.getName().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is empty");
		}
		if(customer.getEmail().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is empty");
		}
			repository.save(customer);
	}

	public void deleteCustomer(Long id) {
          repository.deleteById(id);		
	}

}
