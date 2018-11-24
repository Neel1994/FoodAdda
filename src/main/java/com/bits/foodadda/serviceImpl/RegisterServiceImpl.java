package com.bits.foodadda.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Customer;
import com.bits.foodadda.repository.CustomerRepository;
import com.bits.foodadda.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService{
	
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
