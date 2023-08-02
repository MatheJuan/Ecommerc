package com.devlpjruan.ecommercproject.dto;

import com.devlpjruan.ecommercproject.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

	private Long id;
	@Size(min = 10, max = 30, message = "O campo deve conter entre 3 e 40 caracteres")
	@NotBlank(message = "Campo requerido.")
	private String name;
	@Size(min = 10, message="Descrição precisa no minimo 10 caracteres")
	private String description;
	@Positive(message = "O preço deve ser positivo")
	private double price;
	private String imgurl;
	
	public ProductDto() {
	}
	public ProductDto(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgurl = entity.getImgUrl();
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
