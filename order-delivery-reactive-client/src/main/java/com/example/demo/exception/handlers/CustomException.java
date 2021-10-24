package com.example.demo.exception.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends Exception{

	private int statusCode;
	private String description;
	
	
	

}
