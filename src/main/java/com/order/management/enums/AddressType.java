package com.order.management.enums;

import java.util.Arrays;

public enum AddressType {
	
	HOUSE("HOUSE"),
	OFFICE("OFFICE");
	
	private String addressType;
	
	AddressType(String addressType){
		this.addressType=addressType;
	}
	
	public String getApprovalStatusCode() {
	      return this.addressType;
	}
	
	public static boolean isAddressTypeValue(String formValue)
	{
		return Arrays.stream(AddressType.values()).anyMatch(values -> values.name().contentEquals(formValue.toUpperCase()));
	}

}
