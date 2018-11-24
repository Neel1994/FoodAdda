package com.bits.foodadda.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bits.foodadda.model.Item;
import com.bits.foodadda.service.MenuService;

@Controller
@SessionAttributes(value= {"customerId","customerName","restId"})
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="menu", method = RequestMethod.GET)
	public String displayMenuPage(ModelMap model,@PathParam(value="id") int id) {
		if(id == 0) {
			id = (int)model.get("restId");
			return "redirect:restaurants";
		}
			
		List<Item> menu = menuService.getMenu((long)id);
		model.addAttribute("menu", menu);
		model.addAttribute("restId", id);
		return "menu";
	}
}
