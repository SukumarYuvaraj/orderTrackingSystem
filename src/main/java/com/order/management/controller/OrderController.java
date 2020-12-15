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

import com.order.management.entity.Notification;
import com.order.management.mapper.MapperUtils;
import com.order.management.service.OrderTrackingService;


@RestController
@RequestMapping(path="/orderTracking")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	@Qualifier(value="orderTrackingService")
	private OrderTrackingService service;
	
	@GetMapping(path="/fetchNotifications")
	public List<Notification> retrieveNotifications(){
		logger.info("To fetch all notifications in the system");
		return service.finalAllNotifications();
	}
	
	@GetMapping(path="/fetchNotifications/{id}")
	public Optional<Notification> retrieveNotificationById(@PathVariable Integer id){
		logger.info("To fetch all notifications in the system");
		return service.findNotificationById(id);
	}
	
	
	@PostMapping(path="/saveNotification")
	public void saveNotifications(@RequestBody String message)
	{
		logger.info("To save new notification in to the system");
		try
		{
		service.saveNotifications(MapperUtils.convert(message));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@PostMapping(path="/removeNotification")
	public void removeNotification(@RequestBody String message){
		logger.info("To remove the notification in the system");
		try
		{
		service.removeNotification((MapperUtils.convert(message).getId()));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
