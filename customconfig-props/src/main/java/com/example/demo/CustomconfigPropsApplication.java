package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Product;

@SpringBootApplication
public class CustomconfigPropsApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	 ctx=SpringApplication.run(CustomconfigPropsApplication.class, args);
	
	System.out.println(ctx.getBean("tv",Product.class));
	
	System.out.println(ctx.getBean("product",Product.class));
	
	
	ctx.close();
	}

	@Bean
	public Product tv() {
		Product prod = new Product();
		 prod.setId(101);
		 prod.setName("tv");
		 
		 return prod;
	}
}
