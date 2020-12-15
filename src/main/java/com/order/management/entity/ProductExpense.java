package com.order.management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCT_EXPENSES")
public class ProductExpense {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID ")
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;
	
	@Column(name="OVERALL_PRICE")
	@NotNull
	@ColumnDefault("0.0")
	private Double overallPrice;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductExpenseFields> expenseFields = new HashSet<>();
	
	 //Default-Constructor
	 protected ProductExpense()
	 {
	    	
	 }
	 
	public ProductExpense(Integer id, Product product, @NotNull Double overallPrice,
			Set<ProductExpenseFields> expenseFields) {
		super();
		this.id = id;
		this.product = product;
		this.overallPrice = overallPrice;
		this.expenseFields = expenseFields;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getOverallPrice() {
		return overallPrice;
	}

	public void setOverallPrice(Double overallPrice) {
		this.overallPrice = overallPrice;
	}

	public Set<ProductExpenseFields> getExpenseFields() {
		return expenseFields;
	}

	public void setExpenseFields(Set<ProductExpenseFields> expenseFields) {
		this.expenseFields = expenseFields;
	}

	@Override
	public String toString() {
		return "ProductExpense [id=" + id + ", product=" + product + ", overallPrice=" + overallPrice
				+ ", expenseFields=" + expenseFields + "]";
	}
	 
}
