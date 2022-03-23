package com.example.systemposApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Product;
import com.example.systemposApp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repository;
	@Override
	public Iterable<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product createProduct(Product sale) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Product sale) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long id) throws UsernameOrldNotFound {
		// TODO Auto-generated method stub
		
	}

}
