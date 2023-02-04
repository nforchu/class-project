package com.fashionkings.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fashionkings.core.dto.Product;
import com.fashionkings.core.service.CategoryService;
import com.fashionkings.core.service.ProductService;
import com.fashionkings.core.util.MenuMap;

@Controller
@RequestMapping("product")
public class ProductController {
	
	private CategoryService categoryService;
	private ProductService productService;
	
	public ProductController(CategoryService categoryService, ProductService productService) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable long id) {
		com.fashionkings.core.jpa.Product product = productService.get(id);
        model.addAttribute("title" , product.getTitle());
        model.addAttribute("product", product);
        model.addAttribute("menu", buildMenu());
		return "product";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String allProducts(Model model) {
		
		model.addAttribute("menu", buildMenu());
		model.addAttribute("products", productService.getProducts());
		return "product-list";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("menu", buildMenu());
        model.addAttribute("title" , "Add a new product");
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.allCategories());
		return "product-form";
	}
	
	@RequestMapping(value = "form/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable long id) {
		com.fashionkings.core.jpa.Product product = productService.get(id);
		model.addAttribute("menu", buildMenu())
             .addAttribute("title" , "Add a new product")
             .addAttribute("product", product)	
             .addAttribute("categories", categoryService.allCategories());
		return "product-form";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String addOrUpdate(Model model, @ModelAttribute Product product) {
		com.fashionkings.core.jpa.Product jpaProduct = new com.fashionkings.core.jpa.Product();
		jpaProduct.setId(product.getId()) 
			.setTitle(product.getTitle())  
			.setPrice(product.getPrice())
			.setDescription(product.getDescription())    			
			.setStockQuantity(product.getStockQuantity())
			.setDiscountPercent(product.getDiscountPercent());
		if(product.getId() > 0) {
			jpaProduct = update(jpaProduct, product.getCategories());
		} else {
			jpaProduct = add(jpaProduct, product.getCategories());
		}
		
		model.addAttribute("menu", buildMenu());
		model.addAttribute("product", jpaProduct);
		return String.format("redirect:/product/%s", jpaProduct.getId());
	}
	
	private MenuMap buildMenu()
	{
		MenuMap menuMap = new MenuMap();
		menuMap.setTitle("Categories")
			.addPair("List Products", "/product/list")
			.addPair("New Product", "/product/form");
		return menuMap;
	}
	
	private com.fashionkings.core.jpa.Product add(com.fashionkings.core.jpa.Product product, long[] categoryIds){
		return productService.add(product, categoryIds);
	}
	
	private com.fashionkings.core.jpa.Product update(com.fashionkings.core.jpa.Product product, long[] categoryIds){
		return productService.update(product, categoryIds);
	}
	
}
