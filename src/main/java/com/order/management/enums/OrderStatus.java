package com.order.management.enums;

import java.util.Arrays;

public enum OrderStatus {
	
	ORDER_RECEIVED("ORDER_RECEIVED"),
	ORDER_IN_PROCESSING("ORDER_IN_PROCESSING"),
	ORDER_DELIVERED("ORDER_DELIVERED"),
	ORDER_DECLINED("ORDER_DECLINED");
	
	private String status;

	private OrderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public static boolean isOrderStatusValue(String formValue)
	{
		return Arrays.stream(OrderStatus.values()).anyMatch(values -> values.name().contentEquals(formValue.toUpperCase()));
	}

}
