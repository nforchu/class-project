package com.fashionkings.core.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class CategoryController {



	@RequestMapping(value = "category/details")
	public String getDetails() {
		return "category-details";
	}
	
	
	@RequestMapping(value = "category/form", method = RequestMethod.GET)
	public String form() {
		return "category-form";
	}

	@RequestMapping(value = "category/list", method = RequestMethod.GET)
	public String list() {
		return "category-list";
	}

}
