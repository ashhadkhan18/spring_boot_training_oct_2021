package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	OAuth2RestTemplate template ;
	
	
	@GetMapping("/client/payments")
	public String getDetails() {
		
		return template.getForObject("http://localhost:4040/api/v1/payments", String.class);
	}
	
   

}
