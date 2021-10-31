package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import java.util.*;
import reactor.core.publisher.Mono;

@Component
public class CustomAuthenticationGlobalFilter implements GatewayFilter  {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		 List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
		 
		ServerHttpRequest modifiedRequest = exchange.getRequest().mutate().
		      header("Authorization", authorization.get(0)).build();
		   System.out.println("auth"+ authorization.get(0));
		   
		     return chain.filter(exchange.mutate().request(modifiedRequest).build());

		   }

	

}
