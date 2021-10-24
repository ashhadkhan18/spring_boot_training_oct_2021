package com.example.demo.controllers;

import java.security.Principal;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RefreshScope
@RequestMapping(path = "/api/v1/orders")
@Slf4j
public class OrderController {

	
	
	public OrderService service;

	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public OrderController(OrderService service) {
		super();
		this.service = service;
		log.debug("Order Controller Initialized");
	}

	
	@GetMapping
	@RolesAllowed(value = {"ROLE_ADMIN","ROLE_USER"})
	public List<Order> findAll(){
		
		log.debug("Order Controller Find All Method Called");
		return this.service.findAll();
	}
	
	@PostMapping
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public Order addOrder(@RequestBody Order order,Principal principal) {
		
//		UserDetails user =(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		System.out.println("USER IN ROLE :="+user.getUsername());
		
		log.info("Current User in ROLE :="+principal.getName());
		
		
		log.debug("Order Controller Add Method Called");
		return this.service.addOrder(order);
	}
	
}
