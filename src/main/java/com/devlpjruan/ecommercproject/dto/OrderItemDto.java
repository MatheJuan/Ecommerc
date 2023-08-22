package com.devlpjruan.ecommercproject.dto;

import com.devlpjruan.ecommercproject.entities.OrderItem;

public class OrderItemDto {
	private Long productId;
	private String name;
	private Double price;
	private Integer quantity;
	
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
	public Double getPrice() {
		return price;
	}
	public Integer getQuatity() {
		return quantity;
	}
	public Double getSubtotal() {
		return price * quantity;
	}
	
}
