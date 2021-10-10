package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity
@Table(name = "restaurant_info_oct2021")
public class RestaurantInfo {

	    private int id;
	    private String name;
	    private String serviceArea;
	    private String emailAddress;
	    private String menuType;
	    private String openingHours;
	    
}
