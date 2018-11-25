package com.bits.foodadda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.foodadda.service.ChatbotService;

@Controller
@SessionAttributes(value= {"customerId","customerName","restId","chatBotRequest","chatBotResponse"})
public class ChatbotController {
	
	@Autowired
	ChatbotService chatBotService;
	
	@RequestMapping(value="chatbot", method = RequestMethod.GET)
	public String getChatBotPage(ModelMap model) {
		String name = (String)model.get("customerName");
		if(name.isEmpty())
			return "login";
		else
			return "chatbot";
	}
	
	@RequestMapping(value="chatbot", method = RequestMethod.POST)
	public String chatBot(ModelMap model, @RequestParam String text) {
		System.out.println(text);
		model.addAttribute("chatBotRequest", text);
		
		String response = chatBotService.getResponse(text);
		
		model.addAttribute("chatBotResponse", response);
		return "redirect:chatbot";
	}
}
