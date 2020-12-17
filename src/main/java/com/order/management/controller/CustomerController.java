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

import com.order.management.entity.Customer;
import com.order.management.mapper.SearchForm;
import com.order.management.service.CustomerService;


@RestController
@RequestMapping(path="/orderTracking")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	@Qualifier(value="customerService")
	private CustomerService service;
	
	@GetMapping(path="/fetchCustomers")
	public List<Customer> retrieveCustomers(){
		logger.info("To fetch all customers in the system");
		return service.findAllCustomers();
	}
	
	@GetMapping(path="/fetchCustomer/{id}")
	public Optional<Customer> retrieveCustomerById(@PathVariable Integer id){
		logger.info("To fetch specific customer in the system for the given Id: "+id);
		return service.findCustomerById(id);
	}
	
	@PostMapping(path="/fetchCustomer")
	public List<Customer> retrieveCustomer(@RequestBody SearchForm form)
	{
		logger.info("To fetch customer in the system for the given param: "+ form.toString());
		return service.findCustomer(form);
	}
	
	
	@PostMapping(path="/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		return service.saveCustomer(customer);
	}
	
}
