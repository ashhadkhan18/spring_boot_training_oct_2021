package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.ifaces.RestaurantInfoRepository;
import com.example.demo.model.RestaurantInfo;
import com.example.demo.model.Review;

@SpringBootApplication
public class RestaurantReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			RestaurantInfoRepository repo;
			@Override
			public void run(String... args) throws Exception {
		
				Review review1 = new Review(101, "shyam", "food", "excellent", 4.5);
				Review review2 = new Review(102, "Shiv", "parking", "needs improvement", 2.5);
				
				Set<Review> reviews = new HashSet<>();
				
				  reviews.add(review1);
				  reviews.add(review2);
				  
				  
				  RestaurantInfo sangeetha = 
						  new RestaurantInfo(899, "sanggetha", "chennai" , "sang@abc.com", "veg","600to88" ,reviews);
				  
				  
				  repo.save(sangeetha);
				  
				
			}
		};
	}
}
