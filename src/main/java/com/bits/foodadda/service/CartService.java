package com.bits.foodadda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Cart;
import com.bits.foodadda.model.Customer;
import com.bits.foodadda.model.Item;
import com.bits.foodadda.repository.CartRepository;
import com.bits.foodadda.repository.CustomerRepository;
import com.bits.foodadda.repository.MenuRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MenuRepository menuRepository;
	
	public void addToCart(int itemId,long custId) {
		Item item = menuRepository.getItemById((long)itemId);
		Customer customer = customerRepository.getCustomerById(custId);
		Cart cart = new Cart(customer,item);
		cartRepository.save(cart);
	}
	
	public List<Cart> getCart(long custId) {
		Customer customer = customerRepository.getCustomerById(custId);
		List<Cart> cart = cartRepository.getCart(customer);
		return cart;
	}
	
	public void removeItem(long cartId) {
		cartRepository.removeItem(cartId);
	}
	
	public void submitCart(long custId) {
		Customer customer = customerRepository.getCustomerById(custId);
		cartRepository.submitCart(customer);
	}
}
