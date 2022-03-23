package com.example.systemposApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.systemposApp.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>  {
	public Optional<Product> findById(Long id);
}
