package com.fashionkings.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.jpa.Product;

public interface CategoryService {
	List<Category> allCategories();
	Category getById(long id);
	Category add(Category category);
	Category update(Category category);
	void delete(long id);
    void saveCover(long id, String filename);
    Page<Product> getProducts(long categoryId, int pageNumber);
    List<Product> getPreviewProducts(long categoryId, Pageable pageable);
}
