package com.devlpjruan.ecommercproject.dto;

import com.devlpjruan.ecommercproject.entities.OrderItem;

public class OrderItemDto {
	private Long productId;
	private String name;
	private double price;
	private int quantity;
	
	public OrderItemDto(Long productId, String name, double price, int quatity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quatity;
	}
	public OrderItemDto(OrderItem entity) {
		productId = entity.getProduct().getId();
		name = entity.getProduct().getName();
		price = entity.getPrice();
		quantity = entity.getQuantity();
	}
	public Long getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQuatity() {
		return quantity;
	}
	public double getSubtotal() {
		return price * quantity;
	}
	
}
