package com.cts.eaution.vo;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserVO {
	private Long id;
	@NotNull(message="{validation.sso.user.email.notnull}")
	@Email
	private String email;
	private String password;
	private UserDetailVO userDetails;
	private Role role;
	private Date createdDate;
	private Date modifiedDate;
	@NotNull(message="{validation.sso.user.mphone.notnull}")
	@Size(min = 10, max = 10,message = "{validation.sso.user.mphone.size}")
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public UserDetailVO getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetailVO userDetails) {
		this.userDetails = userDetails;
	}
}
