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


public class RestaurantManager implements User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

}
