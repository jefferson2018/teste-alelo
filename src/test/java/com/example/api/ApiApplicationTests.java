package com.example.api;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.api.service.EnderecoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

  private	EnderecoService enderecoService;

	
	@Test
	public void contextLoads() {
		
		enderecoService.saveEndereco(2L, "08390259");
	}

}
