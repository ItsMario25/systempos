package com.example.systemposApp.service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Product;

public interface ProductService {

	public Iterable<Product> getAllProduct();
	
	public Product createProduct(Product sale)throws Exception;
	
	public Product getProductById(Long id) throws Exception;
	
	public Product updateProduct(Product sale) throws Exception;
	
	public void deleteProduct(Long id) throws UsernameOrldNotFound;
	
}
