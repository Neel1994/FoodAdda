package com.bits.foodadda.service;

public abstract class MealBuilder {
	
	public abstract void AddItem();
	public abstract void SetPrice();
	public abstract Meal GetMeal();
}
