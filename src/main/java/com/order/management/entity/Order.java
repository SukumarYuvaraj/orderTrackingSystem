package com.order.management.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="ORDER_INFO")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID ")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CUST_ID", nullable=false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;
	
	@Column(name="DESCRIPTION")
	@NotBlank(message="Name cannot be blank")
	@Size(min=10, message="Description must be 10 characters minimum")
	private String description;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name="DELIVERY_DATE")
	@NotNull
	private Date deliveryDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	@ColumnDefault("ORDER_RECEIVED")
	private OrderStatus productStatus;
	
	@Column(name="ADVANCE_AMOUNT")
	private Double advanceAmount;
	
	@Column(name="PENDING_AMOUNT")
	private Double pendingAmount;
	
	@Column(name="DELIVERY_CHARGES")
	private Double deliveryCharges;
	
	@Column(name="BASE_PRICE")
	@NotNull
	@ColumnDefault("0.0")
	private Double basePrice;
	
	@Column(name="FINAL_PRICE")
	@NotNull
	@ColumnDefault("0.0")
	private Double finalPrice;
	
	@Column(name="QUANTITY")
	@ColumnDefault("0")
	@NotNull
	private Integer quantity;
	
	@Column(name="GAIN_OR_LOSS")
	private Integer gainOrLoss;
	
	 //Default-Constructor
	 protected Order()
	 {
	    	
	 }

	public Order(Integer id, Customer customer, Product product,
			@NotBlank(message = "Name cannot be blank") @Size(min = 10, message = "Description must be 10 characters minimum") String description,
			Date createdDate, OrderStatus productStatus, Double advanceAmount, Double pendingAmount,
			Double deliveryCharges, @NotNull Double basePrice, @NotNull Double finalPrice, @NotNull Integer quantity,
			Integer gainOrLoss) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.description = description;
		this.createdDate = createdDate;
		this.productStatus = productStatus;
		this.advanceAmount = advanceAmount;
		this.pendingAmount = pendingAmount;
		this.deliveryCharges = deliveryCharges;
		this.basePrice = basePrice;
		this.finalPrice = finalPrice;
		this.quantity = quantity;
		this.gainOrLoss = gainOrLoss;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public OrderStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(OrderStatus productStatus) {
		this.productStatus = productStatus;
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

	public Integer getGainOrLoss() {
		return gainOrLoss;
	}

	public void setGainOrLoss(Integer gainOrLoss) {
		this.gainOrLoss = gainOrLoss;
	}
	 
	 
}
