package com.example.systemposApp.service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Supplier;


public interface SupplierService {

	public Iterable<Supplier> getAllSupplier();
	
	public Supplier createSupplier(Supplier sale)throws Exception;
	
	public Supplier getSupplierById(Long id) throws Exception;
	
	public Supplier updateSupplier(Supplier sale) throws Exception;
	
	public void deleteSupplier(Long id) throws UsernameOrldNotFound;
	
}
