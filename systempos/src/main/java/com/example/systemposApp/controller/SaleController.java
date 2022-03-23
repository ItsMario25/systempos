package com.example.systemposApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaleController {

	@GetMapping({"/saleForm"})
	public String clientForm() {
		return "sale-form/sale-view";
	}
	
}
