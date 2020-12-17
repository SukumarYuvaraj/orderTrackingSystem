package com.order.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="CUSTOMER_INFO")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID ")
	private Integer id;
	
	@Column(name="NAME")
	@NotBlank(message="Name cannot be blank")
	private String name;
	
	@Column(name="EMAIL")
	@Email
	private String email;
	
	@Column(name="MOBILE_NUMBER")
	@NotNull
	//@Size(min =10, message="MobileNumber must be 10 digits")
	private Long mobileNumber;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="CUST_ID")
    private Set<CustomerAddress> address = new HashSet<>();
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name="CUST_ID")
	 private List<Order> orders = new ArrayList<>();
	 
	 //Default-Constructor
	 protected Customer()
	 {
	    	
	 }
	 
	public Customer(Integer id, @NotBlank(message = "Name cannot be blank") String name, @Email String email,
			@NotNull @Size(min = 10, message = "MobileNumber must be 10 digits") Long mobileNumber,
			Long phoneNumber, Set<CustomerAddress> address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumer() {
		return mobileNumber;
	}

	public void setMobileNumer(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<CustomerAddress> getAddress() {
		return address;
	}

	public void setAddress(Set<CustomerAddress> address) {
		this.address = address;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", phoneNumber=" + phoneNumber + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", address=" + address + ", orders=" + orders + "]";
	}

}
