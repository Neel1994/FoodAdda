package com.bits.foodadda.repository;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Item;


public interface MealRepository  extends CrudRepository<Item,Long>{
	
	@Query("select f.price from FoodItem f where f.name=?1 AND f.restaurantId=?2")
	public Item getItemPrice(@PathParam(value = "name") String name,@PathParam(value = "restaurantId") Long restaurantId);

}
