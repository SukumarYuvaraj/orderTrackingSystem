package com.order.management.mapper;

import com.google.gson.Gson;
import com.order.management.entity.Customer;
import com.order.management.entity.Notification;

public class MapperUtils {

	// For Notification Class conversion
	public static Notification convertNotification(String message) {
		return new Gson().fromJson(message, Notification.class);
	}

	// For Customer Class conversion
	public static Customer convertCustomer(String message) {
		return new Gson().fromJson(message, Customer.class);
	}

}
