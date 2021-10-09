package com.example.demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Slf4j
public class Customer {

	


	public Customer(int customerId, String customerName, String email) {
		super();
		log.info("Customer constructor called");
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
	}
	int customerId;
	 String customerName;
	 String email;

	 
	
	

	}
