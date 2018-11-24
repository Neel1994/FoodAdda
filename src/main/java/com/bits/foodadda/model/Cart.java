package com.bits.foodadda.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cart")
@EntityListeners(AuditingEntityListener.class)
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Customer customer;
	@ManyToOne
	private Item item;
	
	public Cart() {
		super();
	}

	public Cart(Customer customer, Item item) {
		super();
		this.customer = customer;
		this.item = item;
	}

	public Cart(long id, Customer customer, Item item) {
		super();
		this.id = id;
		this.customer = customer;
		this.item = item;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", customer=" + customer + ", item=" + item + "]";
	}
	
}
