package com.order.management.enums;

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

}
