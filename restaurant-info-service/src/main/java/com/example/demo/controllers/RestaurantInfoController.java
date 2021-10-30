package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.services.RestaurantInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.*;
import com.example.demo.entity.*;
@RestController
@RequestMapping(path = "/api/v1/restaurants")
@Slf4j
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
		
		@GetMapping("/useParam")
		@Operation(description = "This method will bring  the Restaurant By its Id ")
		public RestaurantInfo getById(@RequestParam ("id") int id){
			
			return this.service.findById(id);
		}
		
		@GetMapping(path = "/srch/area/{area}")
		public List<RestaurantInfo> getByServiceArea(@PathVariable("area") String area){
			
			return this.service.findByServiceArea(area);
		}
		@GetMapping(path = "/srch/meal/{type}")
		public List<RestaurantInfo> getByMeal(@PathVariable("type") String area){
			
			return this.service.findByMenuType(area);
		}
		
		@PostMapping
		public ResponseEntity<Object> addInfo(@RequestBody RestaurantInfo entity){
			
			 

			
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();  


			return ResponseEntity.created(location).body(location);  
		
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
		
		@PatchMapping("/{id}/{revisedTiming}")
		public ResponseEntity<String> updateTiming(@PathVariable("id") int id, @PathVariable("revisedTiming") String timing){
			
			int rowsUpdated = this.service.updateTiming(id, timing);
			
			return ResponseEntity.ok(rowsUpdated+" Updated");
			
		}
		
}
