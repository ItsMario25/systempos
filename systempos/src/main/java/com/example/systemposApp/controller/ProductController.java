package com.example.systemposApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping({"/productForm"})
	public String clientForm() {
		return "product-form/product-view";
	}
	
}
