package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.RestaurantInfoDTO;

import reactor.core.publisher.Flux;

@RestController
public class ClientController {

	
	@Autowired
	public WebClient client;
	
	
	@GetMapping(path = "/client/hotels")
	public Flux<RestaurantInfoDTO> getAllHotels(){
		
	
		return client.get().uri("http://localhost:7075/api/v1/restaurants")
		             .retrieve()
		              .bodyToFlux(RestaurantInfoDTO.class);
		
	}
}
