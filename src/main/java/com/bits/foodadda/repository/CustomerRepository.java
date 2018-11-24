package com.bits.foodadda.repository;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Long> {

	@Query("select c from Customer c where c.email=?1")
	public Customer getCustomerByEmail(@PathParam(value = "email") String email);
	
	@Query("select c from Customer c where c.id=?1")
	public Customer getCustomerById(@PathParam(value = "id") long id);
	
	//Function to handle the login from database
	@Query("select c from Customer c where c.email=?1 AND c.password=?2")
	public Customer login(@PathParam(value = "email") String email,@PathParam(value = "password") String password);
}
