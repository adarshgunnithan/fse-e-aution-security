package com.cts.eaution.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user_details")
@Entity
public class UserDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7313946752793700873L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userDetailId")
	private Long userDetailId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="pin")
	private String pin;
	@Column(name="country")
	private String country;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


}
