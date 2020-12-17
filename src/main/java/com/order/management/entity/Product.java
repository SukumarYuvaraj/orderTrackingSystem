package com.order.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

import com.order.management.enums.ProductStatus;

@Entity
@Table(name="PRODUCT_INFO")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID ")
	private Integer id;
	
	@Column(name="NAME")
	@NotBlank(message="Name cannot be blank")
	@Size(min=04, message="Name must be 4 characters minimum")
	private String name;
	
	@Column(name="DESCRIPTION")
	@NotBlank(message="Name cannot be blank")
	@Size(min=10, message="Description must be 10 characters minimum")
	private String description;
	
	@Column(name="PRICE")
	@NotNull
	@ColumnDefault("0.0")
	private Double price;
	
	@Column(name="QUANTITY")
	@ColumnDefault("0")
	@NotNull
	private Integer quantity;

	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	@ColumnDefault("NOT_AVAILABLE")
	private ProductStatus productStatus;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="PRODUCT_ID")
	private Set<ProductExpenseFields> productExpenseFields ;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private List<Order> orders = new ArrayList<>();
	
	 //Default-Constructor
	 protected Product()
	 {
	    	
	 }

	public Product(
			@NotBlank(message = "Name cannot be blank") @Size(min = 4, message = "Name must be 4 characters minimum") String name,
			@NotBlank(message = "Name cannot be blank") @Size(min = 10, message = "Description must be 10 characters minimum") String description,
			@NotNull Double price, @NotNull Integer quantity, ProductStatus productStatus, Date createdDate,
			Date updatedDate, Set<ProductExpenseFields> productExpenseFields, List<Order> orders) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.productStatus = productStatus;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.productExpenseFields = productExpenseFields;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
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

	public Set<ProductExpenseFields> getProductExpenseFields() {
		return productExpenseFields;
	}

	public void setProductExpenseFields(Set<ProductExpenseFields> productExpenseFields) {
		this.productExpenseFields = productExpenseFields;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", productStatus=" + productStatus + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", productExpenseFields=" + productExpenseFields + ", orders="
				+ orders + "]";
	}
	 
}
