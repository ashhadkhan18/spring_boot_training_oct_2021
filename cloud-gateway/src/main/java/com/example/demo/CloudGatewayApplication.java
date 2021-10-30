package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.example.demo.filters.MyGlobalFilter;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

	 @Bean
	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder,MyGlobalFilter logFilter) {
	    
	  return builder.routes()
	       .route(p -> p.path("/customers/**").filters(f -> f.filter(logFilter, 0))
	           .uri("lb://CUSTOMER-SERVICE-TWO"))
	                .build();
	}

}
