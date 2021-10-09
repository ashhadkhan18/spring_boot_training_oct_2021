package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

@Component
public class RestaurantInfo {

	  private int id;
	    private String name;
	    private String serviceArea;
	    private String emailAddress;
	    private String menuType;
	    private String openingHours;

	    // Field DI to be used
	    
	    @Autowired
	    @Qualifier("foodReview")
	    private Review review;
	    
}
