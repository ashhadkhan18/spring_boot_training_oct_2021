package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.example.demo.filters.CustomAuthenticationGlobalFilter;
import com.example.demo.filters.MyGlobalFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebFluxSecurity
public class CloudGatewayApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

//	 @Bean
//	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder,
//	    		MyGlobalFilter logFilter,CustomAuthenticationGlobalFilter authFilter,TokenRelayGatewayFilterFactory filterFactory) {
//	    
//	  return builder.routes()
//	       .route(p -> p.path("/customers/**")
//	    		   .filters(f -> f.filter(logFilter, 0)).uri("lb://CUSTOMER-SERVICE-TWO"))
//	        .route(p -> p.path("/client/**")
//	            		   .filters(f -> f.filter(authFilter, 0))
//	            		   .uri("http://localhost:4040/"))
//	               .route(p -> p.path("/api/v1/payments/**")
//	            		   .filters(f -> f.filter(filterFactory.apply())).uri("http://localhost:4242/") )
//	                 .build();
//	            		      
//	               	}
//	 
	 
	

}





     