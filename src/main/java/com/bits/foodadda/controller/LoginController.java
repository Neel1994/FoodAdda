package com.bits.foodadda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.foodadda.model.Customer;
import com.bits.foodadda.service.LoginService;

@Controller
@SessionAttributes(value= {"customerId","customerName"})
public class LoginController {
	@Autowired
	LoginService service;
	
	//Display Login Page
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String displayLoginPage() {
		return "login";
	}
	
	//Handle Login
	@RequestMapping(value="loginValidate", method = RequestMethod.POST)
	public String loginUser(Model model, @RequestParam String email, @RequestParam String password) {
		System.out.println(email);
		System.out.println(password);
		Customer customer = service.login(email, password);
		
        if (customer==null) {
        	model.addAttribute("err", "Invalid User Credentials!! Please type the credentials again");
        	return "login";
        }
        else {
        	model.addAttribute("customerId", customer.getId());
        	model.addAttribute("customerName",customer.getName());
        	return "redirect:restaurants";
        }
	}
	
	//Function to log out
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
	  session.invalidate();
	  if(model.containsAttribute("customerId")) {
		  model.asMap().remove("customerId");
		  model.asMap().remove("customerName");
	  }
	  return "redirect:login?act=lo";
	}
}
