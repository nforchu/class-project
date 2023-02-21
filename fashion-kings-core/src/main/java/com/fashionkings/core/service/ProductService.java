package com.fashionkings.core.service;

import java.util.Collection;

import com.fashionkings.core.dto.ProductDTO;
import com.fashionkings.core.jpa.Product;


public interface ProductService {

	Collection<Product> getProducts();
    ProductDTO get(long id);
    ProductDTO add(ProductDTO product);
    void delete(long id);
    ProductDTO update(ProductDTO product);
    void saveImage(long id, String filename);
}
