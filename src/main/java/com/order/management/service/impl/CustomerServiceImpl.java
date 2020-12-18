package com.order.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.entity.Customer;
import com.order.management.entity.CustomerAddress;
import com.order.management.enums.SearchParams;
import com.order.management.mapper.SearchForm;
import com.order.management.repository.CustomerInfoRepository;
import com.order.management.service.CustomerService;
import com.order.management.utils.Utilities;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerInfoRepository repo; 
	
	public CustomerServiceImpl(CustomerInfoRepository repo) {
		this.repo = repo;
	}
	
	public CustomerInfoRepository getRepo() {
		return repo;
	}

	public void setRepo(CustomerInfoRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Customer> findAllCustomers() {
		logger.info("To fetch all the customers available in the system");
		return (List<Customer>) repo.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById(Integer Id) {
		logger.info("To fetch the customer available in the system for given Id : "+Id);
		return  repo.findById(Id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		
		Set<CustomerAddress> address = customer.getAddress();
		address.stream().filter(customerFilter -> null == customerFilter.getCustId())
				.forEach(customerValue -> customerValue.setCustId(customer.getId()));
		customer.setAddress(address);
		
		return repo.save(customer);
	}

	@Override
	public List<Customer> findCustomer(SearchForm form) {

		logger.info("To fetch customer in the system for the given param: " + form.toString());
		List<Customer> customerList = new ArrayList<Customer>();
		Optional<Customer> customerValue = Optional.empty();

		if (Utilities.proceedSearch(form)) {
			switch (SearchParams.valueOf(form.getKey().toUpperCase())) {
			case NAME: {
				customerList.addAll(repo.findByName(form.getValue()));
				break;
			}
			case EMAIL: {
				customerValue = repo.findByEmail(form.getValue());
				customerValue.ifPresent(value -> customerList.add(value));
				break;
			}
			case MOBILENUMBER: {
				customerValue = repo.findByMobileNumber(Long.parseLong(form.getValue()));
				customerValue.ifPresent(value -> customerList.add(value));
				break;
			}
			case PHONENUMBER: {
				customerValue = repo.findByPhoneNumber(Long.parseLong(form.getValue()));
				customerValue.ifPresent(value -> customerList.add(value));
				break;
			}

			default:
				logger.error("Invalid Search Param used for CustomerSearch : " + form.getKey());
			}
		}

		return customerList;
	}

}
