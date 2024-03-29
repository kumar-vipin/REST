package com.example.products;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	int productId;
	String productName;
	int price;

	public Product() {

	}

	public String toString() {
		System.out.println(productId + " " + productName + " " + price);
		return productId + " " + productName + " " + price;
	}

	public Product(int productId, String productName, int price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
