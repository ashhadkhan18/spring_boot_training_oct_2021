package com.example.demo.filters;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		String requestPath = exchange.getRequest().getPath().toString();
		
	        System.out.println("Request path = " + requestPath);
	        
	        HttpHeaders headers = exchange.getRequest().getHeaders();
	        
	        Set<String> headerNames = headers.keySet();
	 
	        headerNames.forEach((header) -> {
	            System.out.println(header + " " + headers.get(header));
	        });
	         return chain.filter(exchange);
	} 
	

}
