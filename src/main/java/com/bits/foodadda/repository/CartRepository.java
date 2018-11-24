package com.bits.foodadda.repository;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bits.foodadda.model.Cart;
import com.bits.foodadda.model.Customer;


public interface CartRepository extends CrudRepository<Cart,Long> {
	
	@Query("select c from Cart c where c.customer=?1")
	public List<Cart> getCart(@PathParam(value = "customer") Customer customer);
	
	@Transactional
	@Modifying
	@Query("delete from Cart c where c.id=?1")
	public void removeItem(@PathParam(value = "id") long id);
	
	@Transactional
	@Modifying
	@Query("delete from Cart c where c.customer=?1")
	public void submitCart(@PathParam(value = "customer") Customer customer);
}
