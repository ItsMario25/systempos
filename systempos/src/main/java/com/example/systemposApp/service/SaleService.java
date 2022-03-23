package com.example.systemposApp.service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Sale;

public interface SaleService {

	public Iterable<Sale> getAllSale();
	
	public Sale createSale(Sale sale)throws Exception;
	
	public Sale getSaleById(Long id) throws Exception;
	
	public Sale updateSale(Sale sale) throws Exception;
	
	public void deleteSale(Long id) throws UsernameOrldNotFound;
	
}
