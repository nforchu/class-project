package com.fashionkings.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


	@Override
	public Category getById(long id) {
		Optional<Category> cat = categoryRepository.findById(id);
		if(cat.isEmpty()) {
			throw new RuntimeException();
		}
		return cat.get();
	}


	@Override
	public Category add(Category category) {
		return categoryRepository.save(category);
	}


	@Override
	public Category update(Category category) {
		Optional<Category> optional = categoryRepository.findById(category.getId());
		if (optional.isEmpty()) {
			throw new RuntimeException("NOT FOUND");
		}
		Category cat = optional.get();
		cat.setTitle(category.getTitle())
		   .setDescription(category.getDescription());
		return categoryRepository.save(cat);
	}


	@Override
	public void delete(long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("NOT FOUND");
		}
		categoryRepository.delete(optional.get());
	}

}
