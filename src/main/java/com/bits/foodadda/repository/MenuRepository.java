package com.bits.foodadda.repository;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Item;
import com.bits.foodadda.model.Restaurant;


public interface MenuRepository extends CrudRepository<Item,Long> {
	
	@Query("select i from Item i where i.restaurant=?1")
	public List<Item> getRestaurantMenu(@PathParam(value="restaurant") Restaurant restaurant);
	
	@Query("select i from Item i where i.id=?1")
	public Item getItemById(@PathParam(value="id") long id);
}
