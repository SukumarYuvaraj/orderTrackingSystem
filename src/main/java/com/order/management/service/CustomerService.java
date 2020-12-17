package com.order.management.service;

import java.util.List;
import java.util.Optional;

import com.order.management.entity.Customer;
import com.order.management.mapper.SearchForm;

public interface CustomerService {
	
	List<Customer> findAllCustomers();
	Optional<Customer> findCustomerById(Integer Id);
	List<Customer> findCustomer(SearchForm form);
	Customer saveCustomer(Customer customer);

}
