package com.order.management.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entity.ReportsView;
import com.order.management.service.ReportsViewService;
import com.order.management.utils.ApplicationConstants;

@RestController
@RequestMapping(path= ApplicationConstants.BASE_CONTEXT)
public class ReportsViewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportsViewController.class);
	
	@Autowired
	@Qualifier(value = "reportsViewService")
	private ReportsViewService service;
	
	@GetMapping(path = "/productSaleStatistics")
	public List<ReportsView> retrieveReportRecords() {
		logger.info("To fetch all orders in the system");
		LocalDate fromDate = LocalDate.of(2020, 01, 01);
		LocalDate toDate = LocalDate.of(2020, 12, 31);
		return service.findAllRecords(fromDate, toDate);
	}

}
