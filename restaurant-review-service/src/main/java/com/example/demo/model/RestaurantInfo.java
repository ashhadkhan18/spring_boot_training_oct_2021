package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "hotel_info_2021")
public class RestaurantInfo  extends RepresentationModel<RestaurantInfo>{

	
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
	    
	    
	    @OneToMany(targetEntity =Review.class,  
	    		cascade = CascadeType.ALL,
	    		            fetch=FetchType.EAGER)
	    		    @JoinColumn(name = "hotel_ref",referencedColumnName = "id")
	    		 
	    		@JsonIgnore

	    Set<Review> reviews;
	    
	    
}
