package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ClientController {

	
	@Autowired
	private RestTemplate template;


	
	@GetMapping(path = "/client")
	@CircuitBreaker(name = "catalogClient", fallbackMethod = "getCatalogFallback")
	public String getCatalog() {
		
		return this.template.getForObject("http://localhost:6060/catalog", String.class);
	}

	
	public String getCatalogFallback(Exception e) {
		
		System.out.println(e.getMessage());
		
		return "Cached Catalog Shown";
	}
	
	

}
