package com.devlpjruan.ecommercproject.dto;

import com.devlpjruan.ecommercproject.entities.Product;

public class ProductMinDto {
	private Long id;
	private String name;
	private double price;
	private String imgurl;

		public ProductMinDto() {
	}
	public ProductMinDto(Long id, String name, double price, String imgurl) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgurl = imgurl;
	}

	public ProductMinDto(Product x) {
		 id = x.getId();
		 name = x.getName();
		 price = x.getPrice();
		 imgurl = x.getImgUrl();	
		 }
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getImgurl() {
		return imgurl;
	}

}
