package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.util.CustomerCreationCondtion;

@SpringBootApplication
public class UnderstandAutoConfigApplication {

	public static void main(String[] args) {
		
	Banner.Mode mode = Banner.Mode.OFF;
	ConfigurableApplicationContext	ctx=new SpringApplicationBuilder(UnderstandAutoConfigApplication.class)
			         .bannerMode(mode).properties("server.port:6060").build().run(args);
	
	  System.out.println(ctx.getBean(Customer.class));
	  
	  
	  //ctx.close();
			
	}

	@Bean
	@Conditional(CustomerCreationCondtion.class)
	public Customer ram() {
		
		return new Customer(101, "Ram", "ram@abc.com");
		
		
	}
	
	@Bean
	@ConditionalOnProperty(name = "spring.application.name", havingValue = "auto")
	public Customer suresh() {
		
		return new Customer(102, "Suresh", "sur@abc.com");
		
		
	}
	
	@Bean
	public Customer shyam() {
		
		return new Customer(103, "Shyam", "shy@abc.com");
		
		
	}
	
	@Bean
	public Item tv() {
		return new Item(101,"tv");
	}
	
	@Bean
	@Primary
	public Item fridge() {
		return new Item(102,"fridge");
	}
	
}
