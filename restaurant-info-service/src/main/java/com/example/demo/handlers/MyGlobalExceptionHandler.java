package com.example.demo.handlers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class MyGlobalExceptionHandler {

	@Value("${com.example.demo.errorcode.one}")
	private String one;
	
	@ExceptionHandler(value = Exception.class)
	public ErrorHandler handleAll(Exception ex, WebRequest request) {
		
		return new ErrorHandler(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
	}
	
	@ExceptionHandler(value = ElementNotFoundException.class)
	public ErrorHandler handleElementNotFoundExecetion(Exception ex, WebRequest request) {
		
		return new ErrorHandler(LocalDateTime.now(),one,request.getDescription(false));
	}
	
}
