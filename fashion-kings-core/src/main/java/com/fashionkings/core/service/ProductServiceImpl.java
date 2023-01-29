package com.fashionkings.core.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.jpa.Product;
import com.fashionkings.core.repository.CategoryRepository;
import com.fashionkings.core.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Collection<Product> getProducts() {
		return productRepo.findAll()
;	}

	@Override
	public Product get(long id) {
		return productRepo.findById(id).get();
	}

	@Override
	public Product add(Product product, long[] categoryIds) {
		for(long id: categoryIds) {
			Optional<Category> optional = catRepository.findById(id);
			if(optional.isPresent()) {
				product.addCategory(optional.get());
			}
		}
		return productRepo.save(product);
	}

	@Override
	public Product update(Product product, long[] categoryIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
