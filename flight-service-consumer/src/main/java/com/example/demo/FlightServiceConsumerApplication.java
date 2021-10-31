package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.example.demo.services.FileService;
import com.example.demo.utils.MySink;

@SpringBootApplication
@EnableBinding(MySink.class)
public class FlightServiceConsumerApplication {

	
	@Autowired
	FileService service;
	public static void main(String[] args) {
		SpringApplication.run(FlightServiceConsumerApplication.class, args);
	}

	@StreamListener("topic_6e")
	public void consumeFlightData(String message) {
		
		System.out.println(message);
		
		service.save(message);
		
	}
}