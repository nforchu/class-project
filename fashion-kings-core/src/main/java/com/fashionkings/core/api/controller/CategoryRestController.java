package com.fashionkings.core.api.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashionkings.core.jpa.Category;
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

    
}
