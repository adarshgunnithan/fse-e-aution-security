package com.cts.eaution.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailVO {
	private Long userDetailId;
	@NotNull(message="{validation.sso.user.fname.notnull}")
	@Size(min = 5, max = 30,message = "{validation.sso.user.fname.size}")
	private String firstName;
	@NotNull(message="{validation.sso.user.lname.notnull}")
	@Size(min = 5, max = 30,message = "{validation.sso.user.lname.size}")
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String pin;
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
	private String country;
}
