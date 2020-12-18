package com.order.management.enums;

import java.util.Arrays;

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
	
	public static boolean isProductStatusValue(String formValue)
	{
		return Arrays.stream(ProductStatus.values()).anyMatch(values -> values.name().contentEquals(formValue.toUpperCase()));
	}

}
