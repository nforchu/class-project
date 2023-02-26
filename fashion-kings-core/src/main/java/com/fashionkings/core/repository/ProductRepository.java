package com.fashionkings.core.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.fashionkings.core.jpa.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByTitle(String title);
	List<Product> findTop2ByTitle(String title);
	
	@Query(value = "SELECT p FROM Product p "
			 + "INNER JOIN p.categories c "
			 + "WHERE c.id = :catId ") 
	List<Product> findPreviewProducts(long catId, Pageable pageable);

}
