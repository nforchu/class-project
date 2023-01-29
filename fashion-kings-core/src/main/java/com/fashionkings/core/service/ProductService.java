package com.fashionkings.core.service;

import java.util.Collection;

import com.fashionkings.core.jpa.Product;

public interface ProductService {

	Collection<Product> getProducts();
    Product get(long id);
    Product add(Product product, long[] categoryIds);
    Product update(Product product, long[] categoryIds);
}
