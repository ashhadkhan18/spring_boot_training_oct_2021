package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.example.demo.model.Customer;
import com.example.demo.util.CustomerCreationCondtion;

@SpringBootApplication
public class UnderstandAutoConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnderstandAutoConfigApplication.class, args);
	}

	@Bean
	@Conditional(CustomerCreationCondtion.class)
	public Customer ram() {
		
		return new Customer(101, "Ram", "ram@abc.com");
		
		
	}
	
	@Bean
	public Customer suresh() {
		
		return new Customer(102, "Suresh", "sur@abc.com");
		
		
	}
	
}
