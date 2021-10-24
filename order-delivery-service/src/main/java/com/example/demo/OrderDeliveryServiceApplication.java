package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.repos.OrderRepository;
import com.example.demo.entity.*;
@SpringBootApplication
public class OrderDeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDeliveryServiceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {
		
			@Autowired
			OrderRepository repo;
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new Order(101,"Ramesh","chennai","walnuts",900,LocalDateTime.now()));
			}
		};
	}
}
