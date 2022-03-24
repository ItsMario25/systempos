package com.example.systemposApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.systemposApp.Exception.CostumeFieldValidationException;
import com.example.systemposApp.entity.Client;
import com.example.systemposApp.entity.Product;
import com.example.systemposApp.service.ProductService;

@Controller
public class ProductController {
	
	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	ProductService productService;

	@GetMapping({"/productForm"})
	public String productForm(Model model) {
		baseAttributerForProductForm(model, new Product(), TAB_LIST);
		return "product-form/product-view";
	}
	
	@GetMapping({"/administracion"})
	public String productAdmini(Model model) {
		baseAttributerForProductForm(model, new Product(), TAB_LIST);
		return "administracion";
	}
	
	private void baseAttributerForProductForm(Model model, Product product,String activeTab) {
		model.addAttribute("productForm", product);
		model.addAttribute("productList", productService.getAllProduct());
		model.addAttribute(activeTab,"active");
	}
	
	@PostMapping({"/productForm"})
	public String createProduct(@Valid @ModelAttribute("productForm")Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForProductForm(model, product, TAB_FORM);
		}else {
			try {
				productService.createProduct(product);
				baseAttributerForProductForm(model, new Product(), TAB_LIST );
				
			} catch (CostumeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForProductForm(model, product, TAB_FORM );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForProductForm(model, product, TAB_FORM );
			}
		}
		return "administracion";
	}
	
	
}
