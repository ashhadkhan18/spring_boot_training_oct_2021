package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Customer shyam() {
		
		return new Customer(104, "Shyam Kumar", "shya@abc.com");
		
		
	}
}
