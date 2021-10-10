package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@AllArgsConstructor

@Component

@Entity
@Table(name = "review_2021")
public class Review extends RepresentationModel<Review>{

	@Id
	@Column(name = "id")
	int id;
	@Column(name = "reviewedby")
	String reviewedBy;
	@Column(name = "reviewedaspect")
	String reviewAspect;
	@Column(name = "reviewedbody")
	String reviewBody;
	@Column(name = "reviewrating")
	double reviewRating;
	public Review() {
		super();

	}

	
}
