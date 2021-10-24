package com.example.demo.exception.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(value = WebClientResponseException.class)
	public ResponseEntity<String> handleRunTimeException(WebClientResponseException ex ) {
		
		return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
		
		
	}
}
