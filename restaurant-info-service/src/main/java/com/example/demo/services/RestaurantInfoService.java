package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.example.demo.entity.RestaurantInfo;
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
	
	
	
}
