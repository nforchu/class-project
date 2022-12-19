package com.fashionkings.core.service;

import org.springframework.stereotype.Service;

import com.fashionkings.core.jpa.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	

	@Override
	public Category[] allCategories() {
		Category cat1 = new Category()
				.setId(1)
				.setTitle("Men")
				.setDescription("Some description for the men's category");
		
		Category cat2 = new Category()
				.setId(1)
				.setTitle("Men")
				.setDescription("Some description for the men's category");
		
		Category[] categories = {cat1, cat2};
		return categories;	
	}

}
