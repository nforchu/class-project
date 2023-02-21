package com.fashionkings.core.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fashionkings.core.jpa.Category;
import com.fashionkings.core.service.CategoryService;
import com.fashionkings.core.util.FileUtil;
import com.fashionkings.core.util.MenuMap;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Value("${app.category.upload.path}")
	private String destFolder;
	private CategoryService categoryService;
	private FileUtil fileUtil;
	
	public CategoryController(CategoryService categoryService, FileUtil fileUtil) {
		this.categoryService = categoryService;
		this.fileUtil = fileUtil;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getDetails(Model model, @PathVariable long id) {
		Category cat = categoryService.getById(id);
		model.addAttribute("category", cat);
		model.addAttribute("menu", buildMenu());
		model.addAttribute("path", "/category/"+cat.getId());
		model.addAttribute("image", cat.getCover());
		
		
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
	
	@RequestMapping(value = "{id}/upload", method = RequestMethod.POST)
	public String upload(@PathVariable long id, @RequestParam("file") MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		filename = fileUtil.save(destFolder, filename, file.getBytes());
		categoryService.saveCover(id, filename);
		return String.format("redirect:/category/%s", id);
	}
	
	@RequestMapping(value = "{id}/images/{filename:.+}")
	@ResponseBody
	public byte[] getCover(@PathVariable String filename) throws IOException {
		Resource resource = fileUtil.load(destFolder, filename);
		return resource.getInputStream().readAllBytes();
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
