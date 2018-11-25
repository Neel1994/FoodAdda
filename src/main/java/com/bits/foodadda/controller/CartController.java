package com.bits.foodadda.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.foodadda.model.Cart;
import com.bits.foodadda.service.CartService;

@Controller
@SessionAttributes(value= {"customerId","customerName","restId"})
public class CartController {
	@Autowired
	CartService cartService;
	
	@RequestMapping(value="addToCart", method = RequestMethod.GET)
	public String addToCart(ModelMap model,@PathParam(value="id") int id) {
		System.out.println("Item Id"+id);
		System.out.println("Restaurant Id"+(int)model.get("restId"));
		
		long custId = (long)model.get("customerId");
		cartService.addToCart(id,custId);
		
		return "redirect:menu?id="+(int)model.get("restId");
	}
	
	@RequestMapping(value="cart", method = RequestMethod.GET)
	public String displayCartPage(ModelMap model) {
		
		if((model.get("customerName") == null))
				return "login";
		else {
			
		     long custId = (long)model.get("customerId");
		     List<Cart> cart = cartService.getCart(custId);
		     model.addAttribute("cart", cart);
		     return "cart"; }
		
	}
	
	@RequestMapping(value="removeFromCart", method = RequestMethod.GET)
	public String removeFromCart(ModelMap model,@PathParam(value="id") int id) {
		cartService.removeItem((long)id);
		return "redirect:cart";
	}
	
	@RequestMapping(value="submitCart", method = RequestMethod.GET)
	public String submitCart(ModelMap model) {
		long custId = (long)model.get("customerId");
		cartService.submitCart(custId);
		return "redirect:restaurants";
	}
}
