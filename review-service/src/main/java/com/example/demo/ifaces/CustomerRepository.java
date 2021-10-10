package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
