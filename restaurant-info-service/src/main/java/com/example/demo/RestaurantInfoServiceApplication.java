package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.ifaces.RestaurantInfoRepository;

@SpringBootApplication
public class RestaurantInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantInfoServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			RestaurantInfoRepository repo;
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new RestaurantInfo(1010, "a2b", "omr", "a2b@abc.com","veg", "6am to 10pm"));
			}
		};
	}
}
