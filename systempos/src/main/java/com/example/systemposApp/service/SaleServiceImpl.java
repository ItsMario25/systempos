package com.example.systemposApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Sale;
import com.example.systemposApp.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleRepository repository;
	
	@Override
	public Iterable<Sale> getAllSale() {
		return repository.findAll();
	}

	@Override
	public Sale createSale(Sale sale) throws Exception {
		sale = repository.save(sale);
		return sale;
	}

	@Override
	public Sale getSaleById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new UsernameOrldNotFound("El Id de venta no existe."));
	}

	@Override
	public Sale updateSale(Sale sale) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSale(Long id) throws UsernameOrldNotFound {
		// TODO Auto-generated method stub
		
	}

}
