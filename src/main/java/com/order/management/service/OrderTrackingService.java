package com.order.management.service;

import java.util.List;
import java.util.Optional;

import com.order.management.entity.NotificationInfo;

public interface OrderTrackingService {
	
	List<NotificationInfo> finalAllNotifications();
	Optional<NotificationInfo> findNotificationById(Integer Id);
	NotificationInfo saveNotifications(NotificationInfo message);
	void removeNotification(Integer Id);
}
