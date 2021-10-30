package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private Customer customer;

	
	@Autowired
	public Tracer tracer;
	
	@NewSpan(name = "secondspan")
	public Customer getCustomer() {
		
		log.info("Get Customer in service called ");
		customer.setId(200);
		customer.setCustomerName("brave balu");
		
		
		return customer;
	
	}
	
}
