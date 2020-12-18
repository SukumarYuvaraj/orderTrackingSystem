package com.order.management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.order.management.entity.Order;
import com.order.management.enums.OrderStatus;

public interface OrderInfoRepository extends CrudRepository<Order, Integer> {

	List<Order> findByCustomerId(Integer Id);
	List<Order> findByProductId(Integer Id);
	List<Order> findByOrderStatus(OrderStatus status);
	List<Order> findByDeliveryDate(LocalDate date);
}
