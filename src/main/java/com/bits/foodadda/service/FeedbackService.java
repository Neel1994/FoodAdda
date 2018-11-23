package com.bits.foodadda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Feedback;
import com.bits.foodadda.model.Restaurant;
import com.bits.foodadda.repository.FeedbackRepository;
import com.bits.foodadda.repository.RestaurantRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public void storeFeedback(long id, String comment) {
		Restaurant restaurant = restaurantRepository.getRestaurantById(id);
		Feedback feedback = new Feedback(restaurant,comment);
		feedbackRepository.save(feedback);
	}
}
