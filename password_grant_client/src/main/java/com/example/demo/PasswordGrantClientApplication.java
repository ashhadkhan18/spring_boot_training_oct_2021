package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@SpringBootApplication
public class PasswordGrantClientApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext ctx =	 SpringApplication.run(PasswordGrantClientApplication.class, args);
		
	    
		
	}

	@Bean
	public OAuth2RestTemplate  template() {
		
	
		ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();

	     details.setAccessTokenUri("http://localhost:4040/oauth/token");
	    
	details.setClientId("myclient");
	details.setClientSecret("pass123");
	details.setUsername("india");
	details.setPassword("india");
	details.setGrantType("password");
	 
	       OAuth2RestTemplate template = new OAuth2RestTemplate(details);
	           return template;

		
		
	}
}
