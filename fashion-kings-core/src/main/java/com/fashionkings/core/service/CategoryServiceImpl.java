package com.fashionkings.core.service;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Override
	public String[] allCategories() {
		String[] categories = {"Men", "Wemen", "Kids"};
		return categories;
	}

}
