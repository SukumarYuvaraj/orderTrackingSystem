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
	@Size(min =10, message="MobileNumber must be 10 digits")
	private Integer mobileNumer;
	
	@Column(name="PHONE_NUMBER")
	private Integer phoneNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<CustomerAddress> address = new HashSet<>();
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 private List<Order> orders = new ArrayList<>();
	 
	 //Default-Constructor
	 protected Customer()
	 {
	    	
	 }
	 
	public Customer(Integer id, @NotBlank(message = "Name cannot be blank") String name, @Email String email,
			@NotNull @Size(min = 10, message = "MobileNumber must be 10 digits") Integer mobileNumer,
			Integer phoneNumber, Set<CustomerAddress> address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumer = mobileNumer;
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

	public Integer getMobileNumer() {
		return mobileNumer;
	}

	public void setMobileNumer(Integer mobileNumer) {
		this.mobileNumer = mobileNumer;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
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
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumer=" + mobileNumer
				+ ", phoneNumber=" + phoneNumber + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", address=" + address + ", orders=" + orders + "]";
	}

}
