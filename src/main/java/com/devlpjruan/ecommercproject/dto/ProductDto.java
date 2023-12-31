package com.devlpjruan.ecommercproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.devlpjruan.ecommercproject.entities.Category;
import com.devlpjruan.ecommercproject.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

	private Long id;
	
	@Size(min = 10, max = 30, message = "O campo deve conter entre 3 e 40 caracteres")
	@NotBlank(message = "Campo requerido.")
	private String name;
	
	@Size(min = 10, message="Descrição precisa no minimo 10 caracteres")
	private String description;
	
	@NotNull(message = "O campo não pode ser nulo")
	@Positive(message = "O preço deve ser positivo")
	private double price;
	
	private String imgurl;
	
	@NotEmpty
	private List<CategoryDto> categoryList = new ArrayList<>();
	
	
	public ProductDto() {
	}
	public ProductDto(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgurl = entity.getImgUrl();
		for(Category cat : entity.getCategories()) {
			categoryList.add(new CategoryDto(cat));
		}
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
	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDto> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
