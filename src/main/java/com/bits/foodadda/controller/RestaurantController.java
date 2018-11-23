package com.bits.foodadda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.foodadda.service.RestaurantService;

@Controller
@SessionAttributes(value= {"customerId","customerName"})
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	//Display Login Page
	@RequestMapping(value="restaurants", method = RequestMethod.GET)
	public String displayRestaurantsPage(ModelMap model) {
		model.addAttribute("restaurants", restaurantService.getRestaurantsList());
		return "restaurants";
	}
	
}
