package com.example.demo.child.context;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.model.Customer;

@SpringBootApplication
@PropertySource("classpath:child-context.yml")
public class ChildContextConfiguration {

	@Bean(name = "child")
	public String getChildFirstBean() {
		return "I am the child";
	}
	
	@Bean
	@Lazy
	public Customer detail() {
		System.out.println("details called ============");
		
		return new Customer(102, "Son Vignesh", "vig@abc.com");
		
	}

}
