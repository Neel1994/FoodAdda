package com.bits.foodadda.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
