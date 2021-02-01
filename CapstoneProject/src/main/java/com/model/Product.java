package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private double cost;
	private String description;
	private String imageRefLink;
	private String genre;
	public Product() {
		super();
	}
	public Product(String productName, double cost, String description, String imageRefLink, String genre) {
		super();
		this.productName = productName;
		this.cost = cost;
		this.description = description;
		this.imageRefLink = imageRefLink;
		this.genre = genre;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageRefLink() {
		return imageRefLink;
	}
	public void setImageRefLink(String imageRefLink) {
		this.imageRefLink = imageRefLink;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
