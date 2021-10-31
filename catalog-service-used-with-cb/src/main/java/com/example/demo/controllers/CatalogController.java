package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

	
	@GetMapping(path = "/catalog")
	public String getCatalog() {
		
		return "Vegeterian Food Catalog";
	}
	
	
}
