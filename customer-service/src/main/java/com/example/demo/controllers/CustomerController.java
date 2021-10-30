package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RefreshScope
@Slf4j
public class CustomerController {

	
	
	@Autowired
	private CustomerService service;
	
	
	@Value("${server.port}")
	private String portNumber;
	
	@Value("${project.author.name}")
	private String customerName;
	
	@GetMapping(path = "/customers")
	public Customer getCustomer() {
		
		log.info("Get Customer Method in the CONTROLLER Called");
		
			
		return service.getCustomer();
	}
	
}
