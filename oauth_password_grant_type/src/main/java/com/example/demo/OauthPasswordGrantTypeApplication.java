package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.example.demo.model.Payment;

@SpringBootApplication
@EnableResourceServer
public class OauthPasswordGrantTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthPasswordGrantTypeApplication.class, args);
	}

	
	@Bean
	public Payment payment() {
		
		return new Payment(2020,"credit card payment", 24000);
	}
}
