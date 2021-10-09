package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class InfoDto {

	private RestaurantInfo info;
	private Review review;
	
	public InfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public InfoDto(@Qualifier("info") RestaurantInfo info, @Qualifier("foodReview") Review review) {
		super();
		this.info = info;
		this.review = review;
	}
	public RestaurantInfo getInfo() {
		return info;
	}
	public void setInfo(RestaurantInfo info) {
		this.info = info;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}

	
	
}
