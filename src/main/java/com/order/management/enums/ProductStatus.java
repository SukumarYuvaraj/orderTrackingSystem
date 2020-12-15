package com.order.management.enums;

public enum ProductStatus {
	
	AVAILABLE("AVAILABLE"),
	NOT_AVAILABLE("NOT_AVAILABLE"),
	UPCOMING("UPCOMING");
	
	private String status;

	private ProductStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
