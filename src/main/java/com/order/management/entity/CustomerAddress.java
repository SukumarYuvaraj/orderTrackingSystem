package com.order.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import com.order.management.enums.AddressType;

@Entity
@Table(name="CUSTOMER_ADDRESS")
public class CustomerAddress {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID ")
	private Integer id;
	
	@Column(name="CUST_ID")
	@NotNull
	private Integer custId; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="ADDRESS_TYPE")
	private AddressType addressType;
	
	@Column(name="ADDRESS_LINE_01")
	@NotBlank(message="AddressLine 01 cannot be blank")
	private String addressLineOne;
	
	@Column(name="ADDRESS_LINE_02")
	private String addressLineTwo;
	
	@Column(name="ADDRESS_LINE_03")
	private String addressLineThree;
	
	@Column(name="CUST_CITY")
	@NotBlank(message="AddressLine 01 cannot be blank")
	private String customerCity;
	
	@Column(name="CUST_STATE")
	@NotBlank(message="AddressLine 01 cannot be blank")
	private String customerState;
	
	@Column(name="CUST_COUNTRY")
	@NotBlank(message="AddressLine 01 cannot be blank")
	private String customerCountry;
	
	@Column(name="ZIPCODE")
	@NotNull
	@Range(min =6, message="ZipCode must be 06 digits")
	private Integer zipCode;
	
	@Column(name="LANDMARK")
	@NotBlank(message="LandMark cannot be blank")
	private String landMark;
	
	
	//Default-Constructor
    protected CustomerAddress() 
    {
    	
    }
    
	public CustomerAddress(Integer id, AddressType addressType,
			@NotBlank(message = "AddressLine 01 cannot be blank") String addressLineOne, String addressLineTwo,
			String addressLineThree, @NotBlank(message = "AddressLine 01 cannot be blank") String customerCity,
			@NotBlank(message = "AddressLine 01 cannot be blank") String customerState,
			@NotBlank(message = "AddressLine 01 cannot be blank") String customerCountry,
			@NotNull @Size(min = 6, message = "ZipCode must be 06 digits") Integer zipCode,
			@NotBlank(message = "LandMark cannot be blank") String landMark) {
		super();
		this.id = id;
		this.addressType = addressType;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressLineThree = addressLineThree;
		this.customerCity = customerCity;
		this.customerState = customerState;
		this.customerCountry = customerCountry;
		this.zipCode = zipCode;
		this.landMark = landMark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAddressLineThree() {
		return addressLineThree;
	}

	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "CustomerAddress [id=" + id + ", custId=" + custId + ", addressType=" + addressType + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", addressLineThree=" + addressLineThree
				+ ", customerCity=" + customerCity + ", customerState=" + customerState + ", customerCountry="
				+ customerCountry + ", zipCode=" + zipCode + ", landMark=" + landMark + "]";
	}
	
}
