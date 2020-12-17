package com.order.management.mapper;

public class CustomerSearchForm {
	
	private String key; 
	private String value;
	
	public CustomerSearchForm(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CustomerSearchForm [key=" + key + ", value=" + value + "]";
	}
	
}
