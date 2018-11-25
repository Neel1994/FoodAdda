package com.bits.foodadda.service;

import java.util.List;

import com.bits.foodadda.model.Cart;

public interface CartService {
	public void addToCart(int itemId,long custId);
	public List<Cart> getCart(long custId);
	public void removeItem(long cartId);
	public void submitCart(long custId);
}
