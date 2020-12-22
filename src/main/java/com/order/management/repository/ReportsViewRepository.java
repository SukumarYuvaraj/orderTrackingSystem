package com.order.management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.order.management.entity.ReportsView;

public interface ReportsViewRepository extends CrudRepository<ReportsView, Integer>{
	
	List<ReportsView> findByDeliveryDateBetween(LocalDate fromDate, LocalDate toDate);

}
