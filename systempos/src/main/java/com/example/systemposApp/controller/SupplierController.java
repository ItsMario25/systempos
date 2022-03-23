package com.example.systemposApp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SupplierController {

	@GetMapping({"/supplierForm"})
	public String clientForm() {
		return "supplier-form/supplier-view";
	}
}
