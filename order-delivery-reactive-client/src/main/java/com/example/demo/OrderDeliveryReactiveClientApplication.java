package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OrderDeliveryReactiveClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDeliveryReactiveClientApplication.class, args);
	}

	@Bean
	public WebClient.Builder builderRef(){
		
		return WebClient.builder();
	}
	
	@Bean
	public WebClient client(WebClient.Builder builderRef) {
		
		return builderRef.build();
	}
}
