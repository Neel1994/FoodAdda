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
	private int ratingPoints;
	
	public Restaurant() {
		super();
	}
	 
	public Restaurant(long id, String name, String address, int rating, int ratingPoints) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.ratingPoints = ratingPoints;
	}

	public int getRatingPoints() {
		return ratingPoints;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRatingPoints(int ratingPoints) {
		this.ratingPoints = ratingPoints;
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
				+ ", ratingPoints=" + ratingPoints + "]";
	}
	
}
