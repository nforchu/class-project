package com.fashionkings.core.dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private long id;
	private long customerId;
	private String orderNumber;
	
	private List<CartItem> products = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<CartItem> getProducts() {
		return products;
	}

	public void setProducts(List<CartItem> products) {
		this.products = products;
	}
	
	public void addItem(CartItem item) {
		this.products.add(item);
	}
	
	
}
