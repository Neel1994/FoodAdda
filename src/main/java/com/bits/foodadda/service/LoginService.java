package com.bits.foodadda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Customer;
import com.bits.foodadda.repository.CustomerRepository;

@Service
public class LoginService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer login(String email, String password) {
		String newPassword = new AppUtils().encryptPassword(password);
		System.out.println("the pass is :" +newPassword);
		Customer customer = customerRepository.login(email, newPassword);
		System.out.println(customer);
		return customer;
	}
}
