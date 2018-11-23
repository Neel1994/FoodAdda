package com.bits.foodadda.repository;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Restaurant;


public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
	
	@Query("select r from Restaurant r")
	public List<Restaurant> getAllRestaurants();
	
	@Query("select r from Restaurant r where r.id=?1")
	public Restaurant getRestaurantById(@PathParam(value="id") long id);
}
