package com.example.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.api.models.Veiculo;


@Repository
public interface VeiculoRepository extends PagingAndSortingRepository<Veiculo, Long >{

	List<Veiculo> findByPlate(String plate);

	Page<Veiculo> findByStatus(Boolean status, Pageable paging);

	Boolean existsByPlate(String plate);

	Page<Veiculo> findByPlateContains(String plate, Pageable paging);

}
