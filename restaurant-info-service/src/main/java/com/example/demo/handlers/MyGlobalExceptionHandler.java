package com.example.demo.handlers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

	
	
	@ExceptionHandler(value = Exception.class)
	public ErrorHandler handleAll(Exception ex, WebRequest request) {
		
		return new ErrorHandler(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
	}
}
