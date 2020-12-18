package com.order.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.entity.Product;
import com.order.management.enums.ProductStatus;
import com.order.management.enums.SearchParams;
import com.order.management.mapper.SearchForm;
import com.order.management.repository.ProductInfoRepository;
import com.order.management.service.ProductService;
import com.order.management.utils.Utilities;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductInfoRepository repo;
	
	public ProductServiceImpl(ProductInfoRepository repo) {
    	this.repo = repo;
	}
	
	public ProductInfoRepository getRepo() {
		return repo;
	}

	public void setRepo(ProductInfoRepository repo) {
		this.repo = repo;
	}



	@Override
	public List<Product> findAllProducts() {
		logger.info("To fetch all the products available in the system");
		return (List<Product>) repo.findAll();
	}

	@Override
	public Optional<Product> findProductById(Integer Id) {
		logger.info("To fetch specific the product available in the system for given Id: "+Id);
		return repo.findById(Id);
	}
	
	@Override
	public Product saveProduct(Product product) {
		logger.info("To save the product information : "+product);
		return repo.save(product);
	}

	@Override
	public List<Product> findProducts(SearchForm form) {

		logger.info("To fetch product in the system for the given param: " + form.toString());
		List<Product> productList = new ArrayList<Product>();
		Optional<Product> productValue = Optional.empty();

		if (Utilities.proceedSearch(form)) {
			switch (SearchParams.valueOf(form.getKey().toUpperCase())) {
			case NAME: {
				productValue = repo.findByName(form.getValue());
				productValue.ifPresent(value -> productList.add(value));
				break;
			}

			case STATUS: {
			    if(ProductStatus.isProductStatusValue(form.getValue().toUpperCase()))
				{
				productList.addAll(repo.findByProductStatus(ProductStatus.valueOf(form.getValue().toUpperCase())));
				}
				break;
			}

			default:
				logger.error("Invalid Search Param used for ProductSearch : " + form.getKey());
			}
		}

		return productList;
	}
	
	
}
