package com.fashionkings.core.api.controller;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashionkings.core.dto.CategoryDTO;
import com.fashionkings.core.dto.ProductDTO;
import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.jpa.Product;
import com.fashionkings.core.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryRestController {
	
	@Autowired
	CategoryService catService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> getAll(){
		List<Category> cats = catService.allCategories();
		return ResponseEntity.status(HttpStatus.OK).body(cats);	
	}
	
	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable long id) {
		Category cat = catService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cat);
	}
	
	@GetMapping(value = "preview")
	@ResponseBody
	public ResponseEntity<?> getPreview(){
		List<CategoryDTO> categories = catService.allCategories()
												 .stream()
												 .map(cat -> cat.toDTO(cat))
												 .collect(Collectors.toList());
		Pageable pageable = PageRequest.of(0, 4);
		categories.forEach(cat -> {
			List<ProductDTO> productList = catService
										   .getPreviewProducts(cat.getId(), pageable)
										   .stream()
										   .map(product -> product.toDTO(product))
										   .collect(Collectors.toList());
			cat.setProducts(productList);
		});		
		return ResponseEntity.status(HttpStatus.OK).body(categories);
	}
	
	@GetMapping(value = "{id}/products") 
	@ResponseBody
	public ResponseEntity<?> getProducts(@PathVariable long id,
			@RequestParam(required = false) Integer pageNumber) {
		pageNumber = pageNumber != null? pageNumber: 0;
		Page<Product> products = catService.getProducts(id, pageNumber);
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

    
}
