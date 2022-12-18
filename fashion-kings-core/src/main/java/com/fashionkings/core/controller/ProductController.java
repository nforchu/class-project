package com.fashionkings.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("products")
public class ProductController {

	@RequestMapping(method = RequestMethod.GET)
	public String allProducts() {
		System.out.println("the products controller ran");
		///get products from database
		return "product-list";
	}
	
}
