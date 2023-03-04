package com.fashionkings.core.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.BeanUtils;

import com.fashionkings.core.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "categories")
@SequenceGenerator(name = "categories_sequence", initialValue = 23) 
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE category_id = ?")
@Where(clause = "deleted=false")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_sequence")
	@Column(name = "category_id")
	private long id;
	
	@Column(name = "title")
	private String title;
	
	
	@Column(name = "cover")
	private String cover;
	
	@Column(name = "description")
	@Lob 
	private String description;
	
	@Column(name = "created")
	private Date  created;
	
	@Column(name = "updated")
	private Date updated;
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Product> products = new ArrayList<>();

	public long getId() {
		return id;
	}

	public Category setId(long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}
	

	public Category setTitle(String title) {
		this.title = title;
		return this;
	}


	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getDescription() {
		return description;
	}

	public Category setDescription(String description) {
		this.description = description;
		return this;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

	
	@PrePersist
	public void prePersist() {
		this.created = new Date(System.currentTimeMillis());
		this.deleted = false;
	}
	
    @PreUpdate
    public void preUpdate () {
    	this.updated = new Date(System.currentTimeMillis());
    }
	
    
    public CategoryDTO toDTO(Category category) {
    	CategoryDTO dto = new CategoryDTO();
    	BeanUtils.copyProperties(this, dto, "product");
    	return dto;
    }
	

}
