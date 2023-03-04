package com.fashionkings.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.jpa.Product;
import com.fashionkings.core.repository.CategoryRepository;
import com.fashionkings.core.repository.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	private ProductRepository productRepo;

	public CategoryServiceImpl(CategoryRepository categoryRepository,
			ProductRepository productRepo) {
		super();
		this.categoryRepository = categoryRepository;
		this.productRepo = productRepo;
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


	@Override
	public void saveCover(long id, String filename) {
		Category cat = categoryRepository.findById(id).orElseThrow();
		cat.setCover(filename);
		categoryRepository.save(cat);
	}


	@Override
	public List<Product> getPreviewProducts(long categoryId, Pageable pageable) {
		return productRepo.findPreviewProducts(categoryId, pageable);
	}


	@Override
	public Page<Product> getProducts(long categoryId, int pageNumber) {
		Pageable paging = PageRequest.of(pageNumber, 30);
		return productRepo.findProducts(categoryId, paging);
	}

}
