package com.order.management.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entity.Product;
import com.order.management.mapper.SearchForm;
import com.order.management.service.ProductService;

@RestController
@RequestMapping(path = "/orderTracking")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	@Qualifier(value = "productService")
	private ProductService service;

	@GetMapping(path = "/fetchProducts")
	public List<Product> retrieveProducts() {
		logger.info("To fetch all products in the system");
		return service.findAllProducts();
	}

	@GetMapping(path = "/fetchProduct/{id}")
	public Optional<Product> retrieveProductById(@PathVariable Integer id) {
		logger.info("To fetch specific product in the system for the given Id: " + id);
		return service.findProductById(id);
	}

	@PostMapping(path = "/fetchProduct")
	public List<Product> retrieveProduct(@RequestBody SearchForm form) {
		logger.info("To fetch product in the system for the given param: " + form.toString());
		return service.findProducts(form);
	}

	@PostMapping(path = "/saveProduct")
	public Product saveCustomer(@RequestBody Product product) {
		logger.info("To save product in the system :" + product.toString());
		return service.saveProduct(product);
	}

}
