package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

@RestController
public class CustomerController {

	
	
	@Autowired
	private Customer customer;
	
	
	@Value("${server.port}")
	private String portNumber;
	
	@Value("${project.author.name}")
	private String customerName;
	
	@GetMapping(path = "/customers")
	public Customer getCustomer() {
		
		customer.setId(Integer.parseInt(portNumber));
		customer.setCustomerName(customerName);
		
		return customer;
	}
	
}
