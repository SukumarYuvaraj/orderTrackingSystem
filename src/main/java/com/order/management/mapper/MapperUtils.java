package com.order.management.mapper;

import com.google.gson.Gson;
import com.order.management.entity.Notification;

public class MapperUtils {
		
	//For Notification Class conversion
	public static Notification convert(String message)
	{
		 return new Gson().fromJson(message, Notification.class);
	}

}
