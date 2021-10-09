package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.RestaurantInfo;
import com.example.demo.model.Review;

@Configuration
public class ApplicationConfig {

	
	// Factory Method
	
	@Bean
	public Review foodReview() {
		
		return new Review(101,"sangeetha", "vicky", "food", "excellent taste", 4.2);
	}
	
	
	
	@Bean
	public RestaurantInfo info() {
		
		RestaurantInfo infoBean = new RestaurantInfo();
		
		infoBean.setId(2020);
		infoBean.setMenuType("veg");
		infoBean.setName("sangeetha");
		infoBean.setEmailAddress("sang@abc.com");
		
		return infoBean;
	}
}
