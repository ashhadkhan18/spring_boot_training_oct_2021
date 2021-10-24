package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotations 
@Data
@NoArgsConstructor
@AllArgsConstructor

// Persistence Annotations
@Entity
@Table(name = "orders_2021")
public class Order {
	
	// Primary Key 
	@Id
	private int orderId;
	private String customerName;
	private String shippingAddress;
	private String item;
	private double orderValue;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime orderDate;
	

}
