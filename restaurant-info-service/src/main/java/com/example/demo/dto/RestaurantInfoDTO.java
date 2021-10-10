package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.example.demo.entity.RestaurantInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class RestaurantInfoDTO {

	

		    private int id;
		    private String name;
		    private String serviceArea;
		    private String emailAddress;
		    private String menuType;
		    private String openingHours;
		    
	}


