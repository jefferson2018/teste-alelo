package com.example.api.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.api.models.Veiculo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VeiculoServiceTest {

	@Autowired
	private VeiculoService veiculoService;
	
	@Test
	public void testSave() throws Exception {
		veiculoService.save(new Veiculo(null, "plate", "model"," manufacturer", "color", true));
	}

	@Test
	public void testUpdateVeiculo() throws Exception {
		Veiculo veiculo = veiculoService.updateVeiculo(new Veiculo(1L, "plate", "model"," manufacturer", "color", true));
		assertNotNull(veiculo);
	}

	@Test
	public void testFindAll() {
		Page<Veiculo> list = veiculoService.findAll(0 , 10);
		assertNotNull(list);
	}

	@Test
	public void testFindByPlate() throws Exception {
		Page<Veiculo> list = veiculoService.findByPlate("plate", 0,10);
		assertNotNull(list);
	}
	
	@Test
	public void findById() throws Exception {
		Veiculo veiculo = veiculoService.findById(1L);
		assertNotNull(veiculo);
		
	}

	
	
	@Test
	public void testFindByStatus() {
		Page<Veiculo> list = veiculoService.findByStatus(true,0 , 10);
		assertNotNull(list);
	}
	

}
