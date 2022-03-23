package com.example.systemposApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.systemposApp.entity.Sale;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long>  {
	public Optional<Sale> findById(Long id);
}
