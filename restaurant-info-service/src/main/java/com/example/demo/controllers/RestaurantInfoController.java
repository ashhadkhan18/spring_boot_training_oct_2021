package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.RestaurantInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.*;
import com.example.demo.entity.*;
@RestController
@RequestMapping(path = "/api/v1/restaurants")
public class RestaurantInfoController {
	
	
		private RestaurantInfoService service;

		public RestaurantInfoController() {
			super();
		}

		@Autowired
		public RestaurantInfoController(RestaurantInfoService service) {
			super();
			this.service = service;
		}
		
		@GetMapping
		@Operation(description = "This method will bring all the Restaurants Information ",
		  parameters = @Parameter(example = "abc") )
		public List<RestaurantInfo> getAll(){
			
			return this.service.findAll();
		}
	
		
		@PostMapping
		public ResponseEntity<RestaurantInfo>  addInfo(@RequestBody RestaurantInfo entity){
			
			RestaurantInfo addedEntity = this.service.add(entity);
			
			
			return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
		
		}
	
		

}
