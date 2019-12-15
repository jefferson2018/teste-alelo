package com.example.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Endereco;
import com.example.api.repository.EnderecoRepository;
import com.example.api.web.rest.CepClientController;


@Service
public class EnderecoService {

	private EnderecoRepository repository;
	
	@Autowired
	private CepClientController cepClient;

	@Autowired
	public EnderecoService(EnderecoRepository repository) {
		this.repository = repository;
	}

	public void saveEndereco(Long idCustomer, String cep) {
		    Endereco endereco = cepClient.buscaEnderecoPor(cep);
		    endereco.setIdCustomer(idCustomer);
			repository.save(endereco);
	}
	
	public void deleteEndereco(Long idEndereco) {
		repository.deleteById(idEndereco);
}
	
	public List<Endereco> findAll() {
		return (List<Endereco>) repository.findAll();
}


}
