package com.bits.foodadda.service;

import java.util.List;

import com.bits.foodadda.model.Item;

public interface MenuService {
	public List<Item> getMenu(long id);
}
