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
import com.example.systemposApp.entity.Sale;
import com.example.systemposApp.service.ClientService;
import com.example.systemposApp.service.SaleService;

@Controller
public class SaleController {

	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	SaleService saleService;
	
	@GetMapping({"/saleForm"})
	public String clientForm(Model model) {
		baseAttributerForSaleForm(model, new Sale(), TAB_LIST);
		return "sale-form/sale-view";
	}
	
	private void baseAttributerForSaleForm(Model model, Sale sale,String activeTab) {
		model.addAttribute("saleForm", sale);
		model.addAttribute("saleList", saleService.getAllSale());
		model.addAttribute(activeTab,"active");
	}
	
	@PostMapping({"/saleForm"})
	public String createClient(@Valid @ModelAttribute("clientForm")Sale sale, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForSaleForm(model, sale, TAB_FORM);
		}else {
			try {
				saleService.createSale(sale);
				baseAttributerForSaleForm(model, new Sale(), TAB_LIST );
				
			} catch (CostumeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForSaleForm(model, sale, TAB_FORM );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForSaleForm(model, sale, TAB_FORM );
			}
		}
		return "sale-form/sale-view";
	}
	
}
