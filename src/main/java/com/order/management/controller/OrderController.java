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

import com.order.management.entity.Order;
import com.order.management.mapper.SearchForm;
import com.order.management.service.OrderService;
import com.order.management.utils.ApplicationConstants;

@RestController
@RequestMapping(path= ApplicationConstants.BASE_CONTEXT)
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	@Qualifier(value = "orderService")
	private OrderService service;
	
	@GetMapping(path = "/fetchOrders")
	public List<Order> retrieveOrders() {
		logger.info("To fetch all orders in the system");
		return service.findAllOrders();
	}

	@GetMapping(path = "/fetchOrder/{id}")
	public Optional<Order> retrieveOrderById(@PathVariable Integer id) {
		logger.info("To fetch specific order in the system for the given Id: " + id);
		return service.findOrderById(id);
	}

	@PostMapping(path = "/fetchOrder")
	public List<Order> retrieveOrder(@RequestBody SearchForm form) {
		logger.info("To fetch order in the system for the given param: " + form.toString());
		return service.findOrder(form);
	}

	@PostMapping(path = "/saveOrder")
	public Order saveOrder(@RequestBody Order order) {
		logger.info("To save order in the system :" + order.toString());
		return service.saveOrder(order);
	}

}
