package com.example.systemposApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {

	@GetMapping({"/supplierForm"})
	public String clientForm() {
		return "supplier-form/supplier-view";
	}
}
