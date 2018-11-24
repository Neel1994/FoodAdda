package com.bits.foodadda.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "restaurant")
@EntityListeners(AuditingEntityListener.class)

public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	private int rating;
	private int ratingCount;
	
	public Restaurant() {
		super();
	}
	 
	public Restaurant(String name, String address, int rating, int ratingCount) {
		super();
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.ratingCount = ratingCount;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", rating=" + rating
				+ ", ratingCount=" + ratingCount + "]";
	}

}
