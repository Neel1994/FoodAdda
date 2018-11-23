package com.bits.foodadda.repository;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Cart;


public interface CartRepository extends CrudRepository<Cart,Long> {

}
