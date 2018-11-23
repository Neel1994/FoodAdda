package com.bits.foodadda.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.foodadda.service.CartService;

@Controller
@SessionAttributes(value= {"customerId","customerName","restId"})
public class CartController {
	@Autowired
	CartService cartService;
	
	@RequestMapping(value="addToCart", method = RequestMethod.GET)
	public String addToCart(ModelMap model,@PathParam(value="id") int id) {
		System.out.println(id);
		System.out.println("Cart controller ke andar saved session id"+(int)model.get("restId"));
		return "redirect:menu?id="+(int)model.get("restId");
	}
}
