package com.example.systemposApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
	
	@GetMapping({"/clientForm"})
	public String clientForm() {
		return "client-form/client-view";
	}
	
	
}
