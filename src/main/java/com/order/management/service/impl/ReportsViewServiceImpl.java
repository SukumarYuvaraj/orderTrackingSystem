package com.order.management.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.entity.ReportsView;
import com.order.management.repository.ReportsViewRepository;
import com.order.management.service.ReportsViewService;

@Service(value="reportsViewService")
public class ReportsViewServiceImpl implements ReportsViewService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private ReportsViewRepository repo;
	
	public ReportsViewServiceImpl(ReportsViewRepository repo) {
		this.repo = repo;
	}

	public ReportsViewRepository getRepo() {
		return repo;
	}

	public void setRepo(ReportsViewRepository repo) {
		this.repo = repo;
	}


	@Override
	public List<ReportsView> findAllRecords(LocalDate fromDate, LocalDate toDate) {
		logger.info("To fetch all the orders available in the system betweeen the given date values: "+fromDate +"----"+toDate);
		return (List<ReportsView>) repo.findByDeliveryDateBetween(fromDate, toDate);
	}

}
