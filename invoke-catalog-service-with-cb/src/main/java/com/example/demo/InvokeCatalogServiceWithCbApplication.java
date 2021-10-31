package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@SpringBootApplication
public class InvokeCatalogServiceWithCbApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvokeCatalogServiceWithCbApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
	
		//CircuitBreakerConfig.custom().failureRateThreshold(0).waitDurationInOpenState(null)
		return new RestTemplate();
	}
	
	
}
