package com.example.api.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.api.models.Veiculo;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class VeiculoRepositoryTest {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	
	@Test
	public void save() {
		Veiculo veiculo = new Veiculo(null, "aaaaa", "aaaaa", "aaaaaaaaa", "aaaaaa", false);
		veiculo = veiculoRepository.save(veiculo);
		assertNotNull(veiculo);
	}
	
	@Test
	public void testFindByPlate() {
		List<Veiculo> veiculos = (List<Veiculo>) veiculoRepository.findAll();
		assertNotNull(veiculos);

	}

}
