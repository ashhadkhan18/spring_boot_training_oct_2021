package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.FlightService;
import com.example.demo.model.*;

@RestController
public class FlightController {

	
	@Autowired
	FlightService service;
	
	
	@PostMapping(path = "/flights")
	public ResponseEntity<String> addFlight(@RequestBody Flight entity) {
		
		
		boolean status= this.service.send(entity);
		
		if(status) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Message Sent");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message NOT Sent");
			
		}
	}
}
