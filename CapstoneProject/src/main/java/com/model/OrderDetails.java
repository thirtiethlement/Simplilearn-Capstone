package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue
	private int orderId;
	@OneToMany
	private List<Product> productList;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserData user;
	private String status;
	public OrderDetails() {
		super();
	}
	public OrderDetails(List<Product> productList, UserData user, String status) {
		super();
		this.productList = productList;
		this.user = user;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
