package com.devlpjruan.ecommercproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlpjruan.ecommercproject.dto.CategoryDto;
import com.devlpjruan.ecommercproject.dto.ProductMinDto;
import com.devlpjruan.ecommercproject.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CatecoryController {

	@Autowired
	private CategoryService service;
 
	@GetMapping
	public ResponseEntity<List<CategoryDto>> findAll(){
		List<CategoryDto> dto = service.findAll();
		return ResponseEntity.ok(dto);
	}
 
	
}
