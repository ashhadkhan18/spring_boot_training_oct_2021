package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ModelConfig {

	@Bean
	public Customer shyam() {
		
		return new Customer(105, "Shyam Reddy", "shyreddy@abc.com");
		
		
	}
}
