package com.fashionkings.core.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fashionkings.core.jpa.Category;

public class ProductDTO extends Object{

    private long id;
    private String title;
    private String description;
    private int stockQuantity;
    private int discountPercent;
    private String image;
    private double price;
	private List<Long> categoryIds;
	private Set<Category> categories = new HashSet<>();

    public long getId() {
        return id;
    }

    public ProductDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProductDTO setTitle(String title) {
        this.title = title;
        return this;
    }

	public String getDescription() {
		return description;
	}

	public ProductDTO setDescription(String description) {
		this.description = description;
		return this;
	}

	

	public int getStockQuantity() {
		return stockQuantity;
	}

	public ProductDTO setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
		return this;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public ProductDTO setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
		return this;
	}
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public ProductDTO setPrice(double price) {
		this.price = price;
		return this;
	}

	

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", stockQuantity="
				+ stockQuantity + ", discountPercent=" + discountPercent + ", price=" + price + ", categories="
				+ categoryIds+ "]";
	}	
	
	
}
