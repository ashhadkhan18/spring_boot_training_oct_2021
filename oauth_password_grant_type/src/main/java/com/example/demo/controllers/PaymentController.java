package com.example.demo.controllers;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;

@RestController
@RequestMapping(path = "/api/v1/payments")
public class PaymentController {

	
	
	@Autowired
	Payment payment;
	
	@GetMapping
	@RolesAllowed(value = {"ROLE_ADMIN","ROLE_USER"})
	@PreAuthorize(value = "#oauth2.hasScope('read')")
	public Payment getPayment(Principal principal) {
		
		System.out.println("Current User :=" +principal.getName());
		return payment;
	}
	
	
	@PostMapping
	@RolesAllowed(value = {"ROLE_ADMIN"})
	@PreAuthorize(value = "#oauth2.hasScope('write')")
	public Payment addPayment(@RequestBody Payment payment,Principal principal) {
		
		System.out.println("Current User :=" +principal.getName());

		return payment;
	}
}
