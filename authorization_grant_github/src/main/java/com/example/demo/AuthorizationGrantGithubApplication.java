package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Payment;

@SpringBootApplication
public class AuthorizationGrantGithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationGrantGithubApplication.class, args);
	}

	@Bean
	public Payment payment() {
		
		return new Payment(5050,"github payment", 24000);
	}
}
