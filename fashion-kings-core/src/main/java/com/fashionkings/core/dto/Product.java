package com.fashionkings.core.dto;

import java.util.Arrays;

public class Product extends Object{

    private long id;
    private String title;
    private String description;
    private int stockQuantity;
    private int discountPercent;
    private double price;
	private long[] categories;

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Product setTitle(String title) {
        this.title = title;
        return this;
    }

	public String getDescription() {
		return description;
	}

	public Product setDescription(String description) {
		this.description = description;
		return this;
	}

	

	public int getStockQuantity() {
		return stockQuantity;
	}

	public Product setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
		return this;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public Product setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public Product setPrice(double price) {
		this.price = price;
		return this;
	}

	public long[] getCategories() {
		return categories;
	}

	public void setCategories(long[] categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", stockQuantity="
				+ stockQuantity + ", discountPercent=" + discountPercent + ", price=" + price + ", categories="
				+ Arrays.toString(categories) + "]";
	}	
	
	
}
