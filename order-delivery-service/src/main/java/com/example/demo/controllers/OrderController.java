package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
	public List<Order> findAll(){
		
		log.debug("Order Controller Find All Method Called");
		return this.service.findAll();
	}
	
	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		
		log.debug("Order Controller Add Method Called");
		return this.service.addOrder(order);
	}
	
}
