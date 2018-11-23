package com.bits.foodadda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Item;
import com.bits.foodadda.model.Restaurant;
import com.bits.foodadda.repository.MenuRepository;
import com.bits.foodadda.repository.RestaurantRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public List<Item> getMenu(long id) {
		Restaurant restaurant = restaurantRepository.getRestaurantById(id);
		List<Item> menu = menuRepository.getRestaurantMenu(restaurant);
		return menu;
	}
}
