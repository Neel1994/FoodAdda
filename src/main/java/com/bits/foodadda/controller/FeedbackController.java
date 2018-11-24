package com.bits.foodadda.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.foodadda.repository.CustomerRepository;
import com.bits.foodadda.service.FeedbackService;

@Controller
@SessionAttributes(value= {"customerId","customerName"})
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping(value="feedback", method = RequestMethod.GET)
	public String displayFeedbackPage(ModelMap model,@PathParam(value="id") int id) {
		System.out.println(id);
		model.addAttribute("id", id);
		return "feedback";
	}
	
	@RequestMapping(value="feedback", method = RequestMethod.POST)
	public String storeFeedback(ModelMap model,int id,String comment) {
		feedbackService.storeFeedback((long)id,comment);
		return "redirect:restaurants";
	}
}
