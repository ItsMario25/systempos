package com.example.systemposApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.systemposApp.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
	public Optional<Client> findById(Long id);
}
