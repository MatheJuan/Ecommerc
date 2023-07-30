package com.devlpjruan.ecommercproject.dto;

import com.devlpjruan.ecommercproject.entities.Product;

public class ProductDto {

	private Long id;
	private String name;
	private String description;
	private double price;
	private String imgurl;
	
	public ProductDto() {
	}
	public ProductDto(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgurl = entity.getImgurl();
	}
	public ProductDto(Long id, String name, String description, double price, String imgurl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgurl = imgurl;
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public String getImgurl() {
		return imgurl;
	}
	
	
}
