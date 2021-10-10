package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RestaurantInfo;

import java.util.*;

@Repository

public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Integer> {

	
	
}
