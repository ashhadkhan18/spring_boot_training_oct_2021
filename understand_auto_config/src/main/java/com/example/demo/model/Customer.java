package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

	 int customerId;
	 String customerName;
	 String email;

	 
	 public Customer(int customerId, String customerName, String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
	}


	@Autowired
	//@Qualifier("fridge")
	 private Item item;
}
