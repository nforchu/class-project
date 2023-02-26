package com.fashionkings.core.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashionkings.core.jpa.Product;
import com.fashionkings.core.repository.ProductRepository;

@RestController
@RequestMapping("test")
public class DemoRestController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable long id) {
		Product product = productRepo.findById(id).orElseThrow();
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@GetMapping("/field/{value}")
	@ResponseBody
	public ResponseEntity<?> findByField(@PathVariable String value) {
		List<Product> product = productRepo.findTop2ByTitle(value);

		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@GetMapping("all") 
	@ResponseBody
	public ResponseEntity<?> getAll() {
		List<Product> product;// = productRepo.findTop5();
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
