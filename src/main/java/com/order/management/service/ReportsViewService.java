package com.order.management.service;

import java.time.LocalDate;
import java.util.List;

import com.order.management.entity.ReportsView;

public interface ReportsViewService {

	List<ReportsView> findAllRecords(LocalDate fromDate, LocalDate toDate);

}
