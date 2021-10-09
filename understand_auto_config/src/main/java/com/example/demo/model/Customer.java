package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor

public class Customer {

	


	int customerId;
	 String customerName;
	 String email;

	 @Autowired
	 Environment env;
	
	 public Customer() {
			super();
		}
	 
	 public void init() {
		 
		 System.out.println("Number of Active Profiles :="+env.getActiveProfiles().length);
	 }

	 public Customer(int customerId, String customerName, String email) {
		super();
		System.out.println("Environment :=" +env);

		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
	}

	 

	@Autowired
	//@Qualifier("fridge")
	 private Item item;
}
