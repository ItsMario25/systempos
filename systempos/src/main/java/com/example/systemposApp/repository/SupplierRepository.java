package com.example.systemposApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.systemposApp.entity.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long>  {
	public Optional<Supplier> findById(Long id);
}
