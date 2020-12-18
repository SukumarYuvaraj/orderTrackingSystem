package com.order.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.entity.Order;
import com.order.management.enums.OrderStatus;
import com.order.management.enums.SearchParams;
import com.order.management.mapper.SearchForm;
import com.order.management.repository.OrderInfoRepository;
import com.order.management.service.OrderService;
import com.order.management.utils.ApplicationConstants;
import com.order.management.utils.Utilities;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderInfoRepository repo;
	
	public OrderServiceImpl(OrderInfoRepository repo) {
		this.repo = repo;
	}

	public OrderInfoRepository getRepo() {
		return repo;
	}

	public void setRepo(OrderInfoRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Order> findAllOrders() {
		logger.info("To fetch all the orders available in the system");
		return (List<Order>) repo.findAll();
	}

	@Override
	public Optional<Order> findOrderById(Integer Id) {
		logger.info("To fetch the specific order available in the system for given Id: "+Id);
		return repo.findById(Id);
	}
	
	@Override
	public Order saveOrder(Order order) {
		logger.info("To save the order information : "+order);
		return repo.save(order);
	}

	@Override
	public List<Order> findOrder(SearchForm form) {
		logger.info("To fetch orders in the system for the given param: " + form.toString());
		List<Order> orderList = new ArrayList<Order>();

		if (Utilities.proceedSearch(form)) {
			switch (SearchParams.valueOf(form.getKey().toUpperCase())) {
			case CUSTOMERID: {
				orderList.addAll(repo.findByCustomerId(Integer.parseInt(form.getValue())));
				break;
			}
			case PRODUCTID: {
				orderList.addAll(repo.findByProductId(Integer.parseInt(form.getValue())));
				break;
			}
			case STATUS: {
			    if(OrderStatus.isOrderStatusValue(form.getValue().toUpperCase()))
				{
			    	orderList.addAll(repo.findByOrderStatus(OrderStatus.valueOf(form.getValue().toUpperCase())));
				}
				break;
			}
			case DELIVERYDATE: {
			    	orderList.addAll(repo.findByDeliveryDate(Utilities.parselocalDate(ApplicationConstants.YYYY_MM_DD, form.getValue().toUpperCase())));
				break;
			}

			default:
				logger.error("Invalid Search Param used for ProductSearch : " + form.getKey());
			}
		}

		return orderList;
	}

}
