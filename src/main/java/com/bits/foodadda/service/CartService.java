package com.bits.foodadda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
}
