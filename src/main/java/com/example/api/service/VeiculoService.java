package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.api.models.Veiculo;
import com.example.api.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	public void save(Veiculo veiculo) throws Exception {
		Boolean existPlate = veiculoRepository.existsByPlate(veiculo.getPlate());
		if(existPlate)
			throw new Exception("Já existe um veiculo cadastrado com essa placa");
		
		veiculoRepository.save(veiculo);
	}
	
	public Veiculo updateVeiculo(Veiculo veiculo) throws Exception {
		Veiculo veiculoBefore = veiculoRepository.findById(veiculo.getId()).orElse(null);
		if(!veiculoBefore.getPlate().equals(veiculo.getPlate()))
			throw new Exception("Placa do veiculo não pode ser alterada");

		return veiculoRepository.save(veiculo);
	}
	
	public Page<Veiculo> findAll(int page, int size){
		Pageable paging = PageRequest.of(page, size, Sort.by("id"));
		Page<Veiculo> veiculos = veiculoRepository.findAll(paging);
		return veiculos;
	}
	
	public Page<Veiculo> findByPlate(String plate, int page, int size){	
		Pageable paging = PageRequest.of(page, size, Sort.by("id"));
		return veiculoRepository.findByPlateContains(plate, paging);
	}

	public Veiculo findById(Long id) throws Exception {
		Veiculo veiculo = veiculoRepository.findById(id).orElse(null);
		if(veiculo == null) 
			throw new Exception("Veiculo não encontrado");
		return veiculo;
	}

	public String delete(Long id) throws Exception {
		Veiculo veiculo = veiculoRepository.findById(id).orElse(null);
		if(veiculo == null) 
			throw new Exception("Veiculo não encontrado");
		veiculoRepository.delete(veiculo);
		return "Excluido com sucesso";
	}

	public  Page<Veiculo>  findByStatus(Boolean status, int page, int size) {
		Pageable paging = PageRequest.of(page, size, Sort.by("id"));
		Page<Veiculo> veiculos = veiculoRepository.findByStatus(status,paging);
		return veiculos;
	}
	
	
}
