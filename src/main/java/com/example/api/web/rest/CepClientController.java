package com.example.api.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.api.domain.Endereco;

@FeignClient(name="viacep", url="https://viacep.com.br", path="ws/")
public interface CepClientController {
 
    @GetMapping(value = "{cep}/json", produces = "application/json")
    Endereco buscaEnderecoPor(@PathVariable("cep") String cep);
}


