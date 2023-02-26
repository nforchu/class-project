package com.fashionkings.core.service;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fashionkings.core.dto.ProductDTO;
import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.jpa.Product;
import com.fashionkings.core.repository.CategoryRepository;
import com.fashionkings.core.repository.ProductRepository;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

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
	public ProductDTO get(long id) {
		Product product = productRepo.findById(id).get();
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(product, dto);
		List<Long> catIds = product.getCategories()
								.stream()
								.map(Category::getId)
								.collect(Collectors.toList());
		dto.setCategoryIds(catIds);
		return dto;
	}

	@Override
	public ProductDTO add(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product, "categories", "id");
		for(long id: productDTO.getCategoryIds()) {
			Optional<Category> optional = catRepository.findById(id);
			if(optional.isPresent()) {
				product.addCategory(optional.get());
			}
		}
		product = productRepo.save(product);
		productDTO.setId(product.getId());		
		return productDTO;
	}

	@Override
	public ProductDTO update(ProductDTO productDTO) {
		Optional<Product> optional = productRepo.findById(productDTO.getId());
		if(optional.isEmpty()) {
			throw new RuntimeException("NOT FOUND");
		}	
		Product product = optional.get();
		for (Category cat : new HashSet<Category>(product.getCategories())) {
			if (productDTO.getCategoryIds().indexOf(cat.getId()) < 0) {
				product.removeCategory(cat);
			}
		}
		
		for (long id: productDTO.getCategoryIds()) {
			Category match = product.getCategories()
									.stream()
									.filter(p -> p.getId() == id)
									.findAny().orElse(null);
			if(match == null ) {
				Optional<Category> opt = catRepository.findById(id);
				product.addCategory(opt.get());
			}
		}
		BeanUtils.copyProperties(productDTO, product, "categories", "id");
		productRepo.save(product);
		return productDTO;
	}

	@Override
	public void saveImage(long id, String filename) {
		Product product = productRepo.findById(id).orElseThrow();
		product.setImage(filename);
		productRepo.save(product);
	}

	@Override
	public void delete(long id) {
		Product product = productRepo.findById(id).orElseThrow();
		productRepo.delete(product);
	}

	@Override
	public Page<Product> browse(int pageNumber) {
		PageRequest pageRequest = PageRequest.of(pageNumber,5);
		Page<Product> jpaPage = productRepo.findAll(pageRequest);
		return jpaPage;
	}

}
