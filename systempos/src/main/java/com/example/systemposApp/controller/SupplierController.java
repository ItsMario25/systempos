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
import com.example.systemposApp.entity.Supplier;
import com.example.systemposApp.service.SupplierService;

@Controller
public class SupplierController {

	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	SupplierService supplierService;
	
	@GetMapping({"/supplierForm"})
	public String supplierForm(Model model) {
		baseAttributerForsupplierForm(model, new Supplier(), TAB_LIST);
		return "supplier-form/supplier-view";
	}
	
	
	private void baseAttributerForsupplierForm(Model model, Supplier supplier,String activeTab) {
		model.addAttribute("supplierForm", supplier);
		model.addAttribute("supplierList", supplierService.getAllSupplier());
		model.addAttribute(activeTab,"active");
	}
	
	@PostMapping({"/supplierForm"})
	public String createProduct(@Valid @ModelAttribute("productForm")Supplier supplier, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForsupplierForm(model, supplier, TAB_FORM);
		}else {
			try {
				supplierService.createSupplier(supplier);
				baseAttributerForsupplierForm(model, new Supplier(), TAB_LIST );
				
			} catch (CostumeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForsupplierForm(model, supplier, TAB_FORM );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForsupplierForm(model, supplier, TAB_FORM );
			}
		}
		return "supplier-form/supplier-view";
	}
}
