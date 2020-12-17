package com.order.management.service;

import java.util.List;
import java.util.Optional;

import com.order.management.entity.Product;
import com.order.management.mapper.SearchForm;

public interface ProductService {
	
	List<Product> findAllProducts();
	Optional<Product> findProductById(Integer Id);
	List<Product> findProducts(SearchForm form);
	Product saveProduct(Product product);

}
