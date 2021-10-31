package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
public class FlightServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceConsumerApplication.class, args);
	}

	@StreamListener("topic_6e")
	public void consumeFlightData(String message) {
		
		System.out.println(message);
	}
}
