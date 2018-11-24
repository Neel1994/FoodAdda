package com.bits.foodadda.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.foodadda.model.Customer;
import com.bits.foodadda.repository.CustomerRepository;
import com.bits.foodadda.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
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
