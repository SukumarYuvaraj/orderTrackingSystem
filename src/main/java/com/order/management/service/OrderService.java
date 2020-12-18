package com.order.management.service;

import java.util.List;
import java.util.Optional;

import com.order.management.entity.Order;
import com.order.management.mapper.SearchForm;

public interface OrderService {
	
	List<Order> findAllOrders();
	Optional<Order> findOrderById(Integer Id);
	List<Order> findOrder(SearchForm form);
	Order saveOrder(Order order);

}
