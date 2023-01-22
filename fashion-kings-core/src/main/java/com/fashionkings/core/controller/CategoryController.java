package com.fashionkings.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.repository.CategoryRepository;
import com.fashionkings.core.service.CategoryService;
import com.fashionkings.core.service.CategoryServiceImpl;
import com.fashionkings.core.util.MenuMap;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	private CategoryService categoryService;
	
	
	private CategoryRepository categoryRepository;

	public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
		this.categoryService = categoryService;
		this.categoryRepository = categoryRepository;
	}

	@RequestMapping(value = "details")
	public String getDetails() {
		return "category-details";
	}
	
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("menu", buildMenu());
		return "category-form";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute Category category) {
		System.err.println(category);
		categoryRepository.save(category);
		return "category-form";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		Category[] categoryList = categoryService.allCategories();
		model.addAttribute("categories", categoryList);
		model.addAttribute("menu", buildMenu());
		return "category-list";
	}
	
	
	private MenuMap buildMenu()
	{
		MenuMap menuMap = new MenuMap();
		menuMap.setTitle("Categories")
			.addPair("List Categories", "/category/list")
			.addPair("New Category", "/category/form");
		return menuMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
