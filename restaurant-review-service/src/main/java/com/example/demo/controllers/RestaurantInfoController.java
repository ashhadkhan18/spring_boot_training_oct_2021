package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.ifaces.RestaurantInfoRepository;
import com.example.demo.model.RestaurantInfo;
import com.example.demo.model.Review;

@RestController
@RequestMapping(path = "/api/v2")
public class RestaurantInfoController {

	
	@Autowired
	private RestaurantInfoRepository infoRepo;
	
	
	@GetMapping(path = "/restaurants")
	public CollectionModel<RestaurantInfo> getAllRestaurants(){
		
		List<RestaurantInfo> list = infoRepo.findAll();
		
		for (RestaurantInfo eachRestaurant : list) {
			
	           Set<Review> reviewList = eachRestaurant.getReviews();
	        
	           for(Review eachReview : reviewList) {
	           
		        	   Link selfLink = WebMvcLinkBuilder.linkTo(ReviewController.class)
		                  .slash("reviews/"+eachReview.getId()).withSelfRel();
		   
		              eachRestaurant.add(selfLink);
		          
	            }
	            
	            
	        }
		
		 Link link = WebMvcLinkBuilder.linkTo(RestaurantInfoController.class)
				 .withSelfRel();
				       
				 return  CollectionModel.of(list, link);
				       }

	   

		
	
}
