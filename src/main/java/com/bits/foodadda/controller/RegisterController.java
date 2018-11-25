package com.bits.foodadda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bits.foodadda.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService service;

	@RequestMapping(value="register", method = RequestMethod.GET)
	public String displayRegisterPage() {
		return "register";
	}
	
	@RequestMapping(value="register", method = RequestMethod.POST)
	public String addCustomer(ModelMap model,@RequestParam String name,@RequestParam String password,@RequestParam String email,@RequestParam String address) {
		if(!service.registerCustomer(name,password,email,address))
			model.addAttribute("err", "User already exists");
		return "login";
	}
	
}
