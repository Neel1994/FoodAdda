package com.bits.foodadda.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Restaurant;
import com.bits.foodadda.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public List<Restaurant> getRestaurantsList() {
		return restaurantRepository.getAllRestaurants();
	}
}
