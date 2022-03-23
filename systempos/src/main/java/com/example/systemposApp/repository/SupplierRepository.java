package com.example.systemposApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.systemposApp.entity.EntryProduct;

@Repository
public interface SupplierRepository extends CrudRepository<EntryProduct, Long>  {
	public Optional<EntryProduct> findById(Long id);
}
