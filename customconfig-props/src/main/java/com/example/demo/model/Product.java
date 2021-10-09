package com.example.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "com.example.demo")
public class Product {

	private int id;
	private String name;
	
	// same as props in application.yml
	// its equivalent injecting the value com.example.demo.label
	private String label;
}
