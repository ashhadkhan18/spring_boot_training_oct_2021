package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.*;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.handlers.ElementNotFoundException;
import com.example.demo.ifaces.RestaurantInfoRepository;

@Service
public class RestaurantInfoService {

	private RestaurantInfoRepository repo;

	@Autowired
	public void setRepo(RestaurantInfoRepository repo) {
		this.repo = repo;
	}
	
	
	public List<RestaurantInfo> findAll(){
		
		return this.repo.findAll();
	}
	 public RestaurantInfo add(RestaurantInfo entity) {
		
		return this.repo.save(entity);
	}
	
    public RestaurantInfo findById(int id){
		
		return this.repo.findById(id)
				 .orElseThrow(() -> new ElementNotFoundException("Element with that id not present"));
	}
		
	public RestaurantInfo update(RestaurantInfo entity) {
		
		return this.repo.save(entity);
	}
	
	public boolean delete(int id) {
		
		boolean result = false;
		
		  if(this.repo.existsById(id)) {
			  this.repo.deleteById(id);
			  result =true;
		  }
		return result;
	}
	
	
}
