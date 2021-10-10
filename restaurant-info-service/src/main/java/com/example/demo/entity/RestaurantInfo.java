package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	
	    @Id
	    @Column(name = "id")
	    private int id;
	    @Column(name = "name")
	    private String name;
	    @Column(name = "servicearea")
	    private String serviceArea;
	    @Column(name = "emailaddress")
	    private String emailAddress;
	    @Column(name = "menutype")
	    private String menuType;
	    @Column(name = "openinghours")
	    private String openingHours;
	    
}
