package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.nashorn.internal.ir.annotations.Reference;

@RestController
@RefreshScope
public class ServiceTwoController {

	
	@Value("${custom.message}")
	private String message;
	
	
	@GetMapping(path = "/second")
	public String getMessage() {
		
		return message.toUpperCase();
	}
}
