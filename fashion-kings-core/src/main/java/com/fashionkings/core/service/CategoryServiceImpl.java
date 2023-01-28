package com.fashionkings.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}


	@Override
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

}
