package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class InvokeSecuredService {

	
	@Autowired
	private WebClient client;
	
	
	@GetMapping(path = "/client/orders")
	public Flux<String> getOrderDetails() {
		
		
		return client.get().uri("http://localhost:6060/api/v1/orders").
		            headers( header -> header.setBasicAuth("lanks", "lanks") )
		            .retrieve()
		            .onStatus(HttpStatus::is5xxServerError, clientResp ->
		               Mono.error(new RuntimeException()))
		            .bodyToFlux(String.class);
		
	}
}
