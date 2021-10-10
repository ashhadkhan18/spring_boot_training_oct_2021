package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RestaurantInfo;
import java.util.*;

import javax.transaction.Transactional;
@Repository

public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Integer> {

	// Query DSL
	
	List<RestaurantInfo> findByServiceArea(String area);
	
	
	// Query DSL with native query
	
	@Query(nativeQuery = true,value = "select * from restaurant_info_oct2021 where menutype=:type")
	List<RestaurantInfo> findByMealType(@Param("type") String type);
	
	
	// Query DSL with JPQL
	
	@Query(value = "update RestaurantInfo set openinghours=:revisedTime where id=:id")
	@Modifying
	@Transactional
	int updateTiming(@Param("revisedTime") String revisedTime, @Param("id") int id);
	
	
}
