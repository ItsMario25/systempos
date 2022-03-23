package com.example.systemposApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.systemposApp.util.*;

@Component
public class CaptchaController {
	
	@Autowired
	private RestTemplate restTemplate;
 
	public boolean isValidCaptcha(String captcha) {
		String url= "https://www.google.com/recaptcha/api/siteverify";
		String params="?secret=6LdBv6MeAAAAAM8Rr08UNYVT6JbPhuXGDJIcTuFp&response="+captcha;
		String completeUrl=url+params;
		CaptchaUtil resp= restTemplate.postForObject(completeUrl, null, CaptchaUtil.class);
		return resp.isSuccess();
	}
}