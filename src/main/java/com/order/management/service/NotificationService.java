package com.order.management.service;

import java.util.List;
import java.util.Optional;

import com.order.management.entity.Notification;

public interface NotificationService {
	
	List<Notification> findAllNotifications();
	Optional<Notification> findNotificationById(Integer Id);
	Notification saveNotifications(Notification message);
	void removeNotification(Integer Id);
}
