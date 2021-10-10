package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifaces.ReviewRepository;
import com.example.demo.model.Review;

@RestController
public class ReviewController {

	
	
	@Autowired
	private ReviewRepository repo;
	
	
	@GetMapping("/reviews/{id}")
	public Review getReview(@PathVariable("id") int id) {
		
	
		return  repo.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
	}
}
