package com.bits.foodadda.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Item;
import com.bits.foodadda.model.Restaurant;
import com.bits.foodadda.repository.MenuRepository;
import com.bits.foodadda.repository.RestaurantRepository;
import com.bits.foodadda.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
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
