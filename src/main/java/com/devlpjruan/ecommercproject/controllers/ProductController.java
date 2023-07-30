package com.devlpjruan.ecommercproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlpjruan.ecommercproject.dto.ProductDto;
import com.devlpjruan.ecommercproject.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public ProductDto findByid(Long id) {
		ProductDto dto = service.findById(id);
		return dto;
	}
}
