package com.bits.foodadda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bits.foodadda.model.Item;
import com.bits.foodadda.repository.MealRepository;



public class Meal {
	
	@Autowired
	MealRepository repository;

	public String name;
	public Long restaurantId;
	
	public Item getItemPrice() {
		return repository.getItemPrice(name,restaurantId);
	}
}

