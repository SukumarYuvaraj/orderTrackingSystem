package com.order.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.order.management.entity.Customer;

@EnableJpaRepositories
public interface CustomerInfoRepository extends CrudRepository<Customer, Integer> {
	
	List<Customer> findByName(String name);
	Optional<Customer> findByEmail(String email);
	Optional<Customer> findByMobileNumber(Long mobileNumber);
	Optional<Customer> findByPhoneNumber(Long phoneNumber);

}
