package com.bits.foodadda.repository;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Long> {

	@Query("select c from Customer c where e.email=?1")
	public Customer getCustomerByEmail(@PathParam(value = "email") String email);
}
