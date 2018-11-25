package com.bits.foodadda.service;

import com.bits.foodadda.model.Customer;

public interface LoginService {
	public Customer login(String email, String password);
}
