package com.cts.eaution.vo;

import java.util.Date;


import com.cts.eaution.entities.Role;
import com.cts.eaution.entities.UserDetails;

public class UserVO {
	private Long id;
	private String email;
	private String password;
	private UserDetails userDetails;
	private Role role;
	private Date createdDate;
	private Date modifiedDate;
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
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
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
}
