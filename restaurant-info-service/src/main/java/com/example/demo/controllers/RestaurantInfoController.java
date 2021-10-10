package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		@Operation(description = "This method will bring all the Restaurants Information ")
		public List<RestaurantInfo> getAll(){
			
			return this.service.findAll();
		}
		
		@GetMapping(path = "/{id}")
		@Operation(description = "This method will bring  the Restaurant By its Id ")
		public RestaurantInfo getById(@PathVariable("id") int id){
			
			return this.service.findById(id);
		}
		@GetMapping(path = "/srch/{area}")
		public List<RestaurantInfo> getByServiceArea(@PathVariable("area") String area){
			
			return this.service.findByServiceArea(area);
		}
		
		
		@PostMapping
		public ResponseEntity<RestaurantInfo>  addInfo(@RequestBody RestaurantInfo entity){
			
			RestaurantInfo addedEntity = this.service.add(entity);
			
			
			return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
		
		}
	
		@PutMapping
		public ResponseEntity<RestaurantInfo>  updateInfo(@RequestBody RestaurantInfo entity){
			
			RestaurantInfo addedEntity = this.service.update(entity);
						
			return ResponseEntity.status(HttpStatus.OK).body(addedEntity);
		
		}
		
		@DeleteMapping(path = "/{id}")
		@Operation(description = "This method will Remove   the Restaurant By its Id ")
		public ResponseEntity<String> removeById(@PathVariable("id") int id){
			
			boolean result = this.service.delete(id);
			
			
			String message ="No Element Found";
			
			if(result) {
				message ="One Element Deleted";
			}
			
			return result?ResponseEntity.status(HttpStatus.OK).body(message):
				ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);

		}
		
		
}
