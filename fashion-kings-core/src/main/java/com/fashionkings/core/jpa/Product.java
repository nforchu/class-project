package com.fashionkings.core.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "status")
	private String status;

	@Column(name = "description")
	private String description;
	
	@Column(name = "quantity")
    private int stockQuantity;
	
	@Column(name = "discount")
    private int discountPercent;
	
	@Column(name = "price", nullable = true)
    private double price;
	
	@Column(name = "created", nullable = false)
	private Date created;
	
	@Column(name = "updated")
	private Date updated;
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList();
}
