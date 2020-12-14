package com.order.management.mapper;

import com.google.gson.Gson;
import com.order.management.entity.NotificationInfo;

public class MapperUtils {
		
	//For Notification Class conversion
	public static NotificationInfo convert(String message)
	{
		 return new Gson().fromJson(message, NotificationInfo.class);
	}

}
