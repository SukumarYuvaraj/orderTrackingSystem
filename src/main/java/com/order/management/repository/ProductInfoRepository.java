package com.order.management.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.order.management.entity.Product;
import com.order.management.enums.ProductStatus;

public interface ProductInfoRepository extends CrudRepository<Product, Integer> {

	List<Product> findByName(String name);
	List<Product> findByStatus(ProductStatus productStatus);
}
