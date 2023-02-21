package com.fashionkings.core.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fashionkings.core.dto.ProductDTO;
import com.fashionkings.core.service.CategoryService;
import com.fashionkings.core.service.ProductService;
import com.fashionkings.core.util.FileUtil;
import com.fashionkings.core.util.MenuMap;


@Controller
@RequestMapping("product")
public class ProductController {
	
	@Value("${app.product.upload.path}")
	private String destFolder;
	private CategoryService categoryService;
	private ProductService productService;
	private FileUtil fileUtil;
	
	public ProductController(CategoryService categoryService,
			ProductService productService, FileUtil fileUtil) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
		this.fileUtil = fileUtil;
				
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String get(Model model, @PathVariable long id) {
		ProductDTO product = productService.get(id);
        model.addAttribute("title" , product.getTitle());
        model.addAttribute("product", product);
        model.addAttribute("menu", buildMenu());
        model.addAttribute("path", "/product/"+product.getId());
        model.addAttribute("image", product.getImage());
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
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.allCategories());
		return "product-form";
	}
	
	@RequestMapping(value = "form/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable long id) {
		ProductDTO product = productService.get(id);
		model.addAttribute("menu", buildMenu())
             .addAttribute("title" , "Add a new product")
             .addAttribute("product", product)	
             .addAttribute("categories", categoryService.allCategories());
		return "product-form";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String addOrUpdate(Model model, @ModelAttribute ProductDTO product) {
		System.out.println(product);
		if(product.getId() > 0) {
			product = update(product);
		} else {
			product = add(product);
		}
		
		model.addAttribute("menu", buildMenu());
		model.addAttribute("product", product);
		return String.format("redirect:/product/%s", product.getId());
	}
	
	@RequestMapping(value = "{id}/upload", method = RequestMethod.POST)
	public String upload(@PathVariable long id, 
			@RequestParam("file") MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		filename = fileUtil.save(destFolder, filename, file.getBytes());
		productService.saveImage(id, filename);
		return String.format("redirect:/product/%s", id);
	}
	
	@RequestMapping(value = "{id}/images/{filename:.+}")
	@ResponseBody
	public byte[] getCover(@PathVariable String filename) throws IOException {
		Resource resource = fileUtil.load(destFolder, filename);
		return resource.getInputStream().readAllBytes();
	}
	
	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable long id) {
		productService.delete(id);
		return "redirect:/product/list";
	}
	
	private MenuMap buildMenu()
	{
		MenuMap menuMap = new MenuMap();
		menuMap.setTitle("Products")
			.addPair("List Products", "/product/list")
			.addPair("New Product", "/product/form");
		return menuMap;
	}
	
	private ProductDTO add(ProductDTO product){
		return productService.add(product);
	}
	
	private ProductDTO update(ProductDTO product){
		return productService.update(product);
	}
	
}
