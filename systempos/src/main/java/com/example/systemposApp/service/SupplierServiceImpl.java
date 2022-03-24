package com.example.systemposApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Supplier;
import com.example.systemposApp.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierRepository repository;
	
	@Override
	public Iterable<Supplier> getAllSupplier() {
		return repository.findAll();
	}

	@Override
	public Supplier createSupplier(Supplier supplier) throws Exception {
		supplier = repository.save(supplier);
		return supplier;
	}

	@Override
	public Supplier getSupplierById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new UsernameOrldNotFound("El Id del proveedor no existe."));
	}

	@Override
	public Supplier updateSupplier(Supplier sale) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSupplier(Long id) throws UsernameOrldNotFound {
		// TODO Auto-generated method stub
		
	}

	
}
