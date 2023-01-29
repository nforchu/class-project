package com.fashionkings.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionkings.core.jpa.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
