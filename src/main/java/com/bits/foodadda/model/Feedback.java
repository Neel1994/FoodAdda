package com.bits.foodadda.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "feedback")
@EntityListeners(AuditingEntityListener.class)
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Restaurant restaurant;
	private String comment;
	
	public Feedback() {
		super();
	}
	
	public Feedback(Restaurant restaurant, String comment) {
		super();
		this.restaurant = restaurant;
		this.comment = comment;
	}
	

	public Feedback(long id, Restaurant restaurant, String comment) {
		super();
		this.id = id;
		this.restaurant = restaurant;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", restaurant=" + restaurant + ", comment=" + comment + "]";
	}
	
}
