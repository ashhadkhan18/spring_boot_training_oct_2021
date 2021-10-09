package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@AllArgsConstructor

@Component("reviewBean")
public class Review {

	int id;
	String restaurantName;
	String reviewedBy;
	String reviewAspect;
	String reviewBody;
	double reviewRating;
	public Review() {
		super();

		System.out.println("Review Initialized");
	}

	
}
