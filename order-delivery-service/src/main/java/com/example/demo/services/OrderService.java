package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repos.OrderRepository;
import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	
	private OrderRepository repo;

	@Autowired
	public void setRepo(OrderRepository repo) {
		this.repo = repo;
		
		log.info("Repository Injected");
	}
	
	
	public List<Order> findAll(){
		
		log.info("Find All Order Method Called");
		return this.repo.findAll();
	}
	
	public Order addOrder(Order entity) {
		
		log.info("Add Order Method Called");
		
		return this.repo.save(entity);
		
	}
	
	
}
