package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class ClientController {

	
	@Autowired
	private WebClient client;
	
	
	private static String baseURI="http://CUSTOMER-SERVICE/";
	
	
	@GetMapping(path = "/client/customers")
	public Flux<String> getCustomers(){
		
		String reqURI = baseURI+"customers";
		
		return client.get().uri(reqURI).retrieve().bodyToFlux(String.class);
		
	}
}
