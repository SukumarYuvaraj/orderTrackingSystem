package com.order.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCT_EXPENSE_FIELDS")
public class ProductExpenseFields {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID ")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_EXPENSES_ID", nullable=false)
	private ProductExpense expense;
	
	@Column(name="NAME")
	@NotBlank(message="Name cannot be blank")
	private String name;
	
	@Column(name="QUANTITY")
	@ColumnDefault("0")
	@NotNull
	private Integer quantity;
	
	@Column(name="PRICE")
	@NotNull
	@ColumnDefault("0.0")
	private Double price;
	
	 //Default-Constructor
	 protected ProductExpenseFields()
	 {
	    	
	 }

	public ProductExpenseFields(Integer id, ProductExpense expense,
			@NotBlank(message = "Name cannot be blank") String name, @NotNull Integer quantity, @NotNull Double price) {
		super();
		this.id = id;
		this.expense = expense;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductExpense getExpense() {
		return expense;
	}

	public void setExpense(ProductExpense expense) {
		this.expense = expense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductExpenseFields [id=" + id + ", expense=" + expense + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
}
