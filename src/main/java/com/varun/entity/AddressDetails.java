package com.varun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER_ADDRESS")
public class AddressDetails {
	
	@Id
	@Column(name="CUSTOMER_ID")
	String customerId;
	
	@Column(name="ADDRESS_TYPE")
	String addressType;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="HOUSE_NUMBER")
	String houseNumber;
	
	@Column(name="STREET_NAME")
	String streetName;
	
	@Column(name="CITY")
	String city;
	
	@Column(name="STATE")
	String state;
	
	@Column(name="PINCODE")
	String pincode;
	
	@Column(name="COUNTRY")
	String country;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
