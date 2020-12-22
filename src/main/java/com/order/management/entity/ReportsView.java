package com.order.management.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name ="REPORTS_VIEW")
@Immutable
public class ReportsView  {

	@Id
	@Column(name="ORDER_ID")
	private Integer orderId;
	
	@Column(name="PRODUCT_NAME")
	private String productName; 
	
	@Column(name="PRODUCT_ID")
	private Integer productId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName; 
	
	@Column(name="CUSTOMER_CONTACT")
	private Long mobileNumber; 
	
	@Column(name="ORDER_DESCRIPTION")
	private String orderDescription; 
	
	@Column(name="QUANTITY")
	private Integer quantity; 
	
	@Column(name="DELIVERY_DATE")
	private LocalDate deliveryDate;
	
	@Column(name="EXPENSE_COST")
	private Double expenseCost; 
	
	@Column(name="SALES_COST")
	private Double salesCost; 
	
	@Column(name="PROFIT_VALUE")
	private Double profitValue; 
	
	@Column(name="PROFIT_PERCENTAGE")
	private Double profitPercentage; 
	
	//Default Constructor
	private ReportsView()
	{
		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getExpenseCost() {
		return expenseCost;
	}

	public void setExpenseCost(Double expenseCost) {
		this.expenseCost = expenseCost;
	}

	public Double getSalesCost() {
		return salesCost;
	}

	public void setSalesCost(Double salesCost) {
		this.salesCost = salesCost;
	}

	public Double getProfitValue() {
		return profitValue;
	}

	public void setProfitValue(Double profitValue) {
		this.profitValue = profitValue;
	}

	public Double getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(Double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	@Override
	public String toString() {
		return "ReportsView [orderId=" + orderId + ", productName=" + productName + ", productId=" + productId
				+ ", customerName=" + customerName + ", mobileNumber=" + mobileNumber + ", orderDescription="
				+ orderDescription + ", quantity=" + quantity + ", deliveryDate=" + deliveryDate + ", expenseCost="
				+ expenseCost + ", salesCost=" + salesCost + ", profitValue=" + profitValue + ", profitPercentage="
				+ profitPercentage + "]";
	}
	
}
