package com.order.management.enums;

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

}
