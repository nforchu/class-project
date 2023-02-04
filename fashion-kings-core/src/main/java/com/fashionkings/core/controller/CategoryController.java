package com.fashionkings.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getDetails(Model model, @PathVariable long id) {
		System.out.println("method called");
		model.addAttribute("category", categoryService.getById(id));
		model.addAttribute("menu", buildMenu());
		return "category-details";
	}
	
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("menu", buildMenu());
		model.addAttribute("category", new Category());
		return "category-form";
	}
	
	
	
	@RequestMapping(value = "form/{id}", method = RequestMethod.GET)
	public String editForm (Model model,  @PathVariable long id) {
		Category category = categoryService.getById(id);
		model.addAttribute("category", category);
		model.addAttribute("title", String.format("Edit category: %s ", category.getTitle()));
		model.addAttribute("menu", buildMenu());
		return "category-form";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String addOrUpdate(Model model, @ModelAttribute Category category) {
		if(category.getId() > 0) {
			category = update(category);
		} else {
			category = add(category);
		}
		model.addAttribute("category", category);
		model.addAttribute("title", String.format("Edit category: %s ", category.getTitle()));
		model.addAttribute("menu", buildMenu());
		return "redirect:/category/"+category.getId();
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Category> categoryList = categoryService.allCategories();
		model.addAttribute("categories", categoryList);
		model.addAttribute("menu", buildMenu());
		return "category-list";
	}
	
	@RequestMapping(value = "{id}/delete",  method = RequestMethod.GET)
    public String confirmDelete(Model model, @PathVariable long id) {
		System.out.println("Will delete");
    	Category category = categoryService.getById(id);
        model.addAttribute("title" , String.format("Delete category %s", category.getTitle()));
        model.addAttribute("category", category);
        model.addAttribute("menu", buildMenu());
        return "category-delete";
    }
	
	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	public String delete(Model model, @PathVariable long id) {
		categoryService.delete(id);
		return "redirect:/category/list";
	}
	
	
	
	private Category add(Category category) {
    	return categoryService.add(category);
    }
	    
    private Category update(Category category) {
    	return categoryService.update(category);
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
