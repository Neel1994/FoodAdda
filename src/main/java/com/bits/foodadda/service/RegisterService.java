package com.bits.foodadda.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bits.foodadda.model.Customer;
import com.bits.foodadda.repository.CustomerRepository;
import com.bits.foodadda.service.AppUtils;


public class RegisterService {
	
	@Autowired
	CustomerRepository repository;
	public boolean registerCustomer(Customer newCustomer) {
		String newPassword = new AppUtils().encryptPassword(newCustomer.getPassword());
		newCustomer.setPassword(newPassword);
		
		Customer temp = repository.getCustomerByEmail(newCustomer.getEmail());
		System.out.println(temp);
		if(temp==null) {
			repository.save(newCustomer);
			return true;
		}		
		else
			return false;
	}
}
