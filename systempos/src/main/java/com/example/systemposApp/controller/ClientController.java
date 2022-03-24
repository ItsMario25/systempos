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
import com.example.systemposApp.entity.User;
import com.example.systemposApp.service.ClientService;

@Controller
public class ClientController {
	
	
	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	ClientService clientService;
	
	@GetMapping({"/clientForm"})
	public String clientForm(Model model) {
		baseAttributerForClientForm(model, new Client(), TAB_LIST);
		return "client-form/client-view";
	}
	
	private void baseAttributerForClientForm(Model model, Client client,String activeTab) {
		model.addAttribute("clientForm", client);
		model.addAttribute("clientList", clientService.getAllClients());
		model.addAttribute(activeTab,"active");
	}
	
	@PostMapping({"/clientForm"})
	public String createClient(@Valid @ModelAttribute("clientForm")Client client, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForClientForm(model, client, TAB_FORM);
		}else {
			try {
				clientService.createClient(client);
				baseAttributerForClientForm(model, new Client(), TAB_LIST );
				
			} catch (CostumeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForClientForm(model, client, TAB_FORM );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForClientForm(model, client, TAB_FORM );
			}
		}
		return "client-form/client-view";
	}
	
	
}
