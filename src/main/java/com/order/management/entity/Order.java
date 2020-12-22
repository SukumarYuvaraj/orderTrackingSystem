package com.order.management.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.order.management.enums.OrderStatus;

@Entity
@Table(name = "ORDER_INFO")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID ")
	private Integer id;

	@Column(name = "CUST_ID")
	@NotNull
	private Integer customerId;

	@Column(name = "PRODUCT_ID")
	@NotNull
	private Integer productId;

	@Column(name = "DESCRIPTION")
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 10, message = "Description must be 10 characters minimum")
	private String description;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "DELIVERY_DATE")
	@NotNull
	private LocalDate deliveryDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	@ColumnDefault("ORDER_RECEIVED")
	private OrderStatus orderStatus;

	@Column(name = "ADVANCE_AMOUNT")
	private Double advanceAmount;

	@Column(name = "PENDING_AMOUNT")
	private Double pendingAmount;

	@Column(name = "DELIVERY_CHARGES")
	private Double deliveryCharges;

	@Column(name = "BASE_PRICE")
	@NotNull
	@ColumnDefault("0.0")
	private Double basePrice;

	@Column(name = "FINAL_PRICE")
	@NotNull
	@ColumnDefault("0.0")
	private Double finalPrice;

	@Column(name = "QUANTITY")
	@ColumnDefault("0")
	@NotNull
	private Integer quantity;

	// Default-Constructor
	protected Order() {

	}

	public Order(Integer customerId, Integer productId,
			@NotBlank(message = "Name cannot be blank") @Size(min = 10, message = "Description must be 10 characters minimum") String description,
			Date createdDate, Date updatedDate, @NotNull LocalDate deliveryDate, OrderStatus orderStatus,
			Double advanceAmount, Double pendingAmount, Double deliveryCharges, @NotNull Double basePrice,
			@NotNull Double finalPrice, @NotNull Integer quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.deliveryDate = deliveryDate;
		this.orderStatus = orderStatus;
		this.advanceAmount = advanceAmount;
		this.pendingAmount = pendingAmount;
		this.deliveryCharges = deliveryCharges;
		this.basePrice = basePrice;
		this.finalPrice = finalPrice;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(Double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public Double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(Double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public Double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(Double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", description="
				+ description + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", deliveryDate="
				+ deliveryDate + ", orderStatus=" + orderStatus + ", advanceAmount=" + advanceAmount
				+ ", pendingAmount=" + pendingAmount + ", deliveryCharges=" + deliveryCharges + ", basePrice="
				+ basePrice + ", finalPrice=" + finalPrice + ", quantity=" + quantity + "]";
	}

}
