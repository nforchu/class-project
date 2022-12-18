package com.fashionkings.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("category")
public class CategoryController {

	@RequestMapping(value = "details")
	public String getDetails() {
		return "category-details";
	}
	
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form() {
		return "category-form";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		return "category-list";
	}

}
