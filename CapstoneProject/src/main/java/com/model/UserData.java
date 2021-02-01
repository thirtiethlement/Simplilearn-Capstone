package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserData {

	@Id
	@GeneratedValue
	private int userId;
	private String role;
	private String username;
	private String password;
	private String emailAddress;
	private String billingAddress;
	public UserData() {
		super();
	}
	public UserData(String role, String username, String password, String emailAddress, String billingAddress) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.billingAddress = billingAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	
}
