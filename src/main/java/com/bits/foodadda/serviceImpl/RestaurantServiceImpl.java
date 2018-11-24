package com.bits.foodadda.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Restaurant;
import com.bits.foodadda.repository.RestaurantRepository;
import com.bits.foodadda.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public List<Restaurant> getRestaurantsList() {
		return restaurantRepository.getAllRestaurants();
	}
}
