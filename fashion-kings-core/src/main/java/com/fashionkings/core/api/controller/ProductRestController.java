package com.fashionkings.core.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashionkings.core.dto.ProductDTO;
import com.fashionkings.core.jpa.Product;
import com.fashionkings.core.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductRestController {
	
	@Autowired
	ProductService prodService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> getAll(){
		Collection<Product> products = prodService.getProducts();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable long id) {
		ProductDTO product = prodService.get(id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@GetMapping("browse")
	@ResponseBody
	public ResponseEntity<?> browse(@RequestParam(required = false) Integer pageNumber){
		pageNumber = pageNumber != null ? pageNumber : 0;
		//Page<ProductDTO> products = prodService.browse(pageNumber);
		return ResponseEntity.status(HttpStatus.OK).body(prodService.browse(pageNumber));
	}

}
