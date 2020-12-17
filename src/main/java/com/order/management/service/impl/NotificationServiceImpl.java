package com.order.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.entity.Notification;
import com.order.management.repository.NotificationInfoRepository;
import com.order.management.service.NotificationService;

@Service(value="notificationService")
public class NotificationServiceImpl implements NotificationService {
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
	
	@Autowired
	private NotificationInfoRepository repo;
	
	public NotificationInfoRepository getRepo() {
		return repo;
	}

	public void setRepo(NotificationInfoRepository repo) {
		this.repo = repo;
	}


	@Override
	public List<Notification> findAllNotifications() {
		logger.info("To fetch all the Notifications available in the system");
		return (List<Notification>) repo.findAll();
	}

	@Override
	public Notification saveNotifications(Notification message) {
		logger.info("To save new Notification in to the system");
		return repo.save(message);
	}

	@Override
	public Optional<Notification> findNotificationById(Integer Id) {
		logger.info("To find Notification by Id in the system");
		return repo.findById(Id);
	}

	@Override
	public void removeNotification(Integer Id) {
		logger.info("To remove Notification by Id in the system");
		if(repo.existsById(Id))
		{
		repo.deleteById(Id);
		}
	}
	
	

}
