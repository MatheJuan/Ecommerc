package com.devlpjruan.ecommercproject.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devlpjruan.ecommercproject.dto.ProductDto;
import com.devlpjruan.ecommercproject.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDto> findByid(@PathVariable Long id) {
		ProductDto dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<Object>> findAll(Pageable pageable) {
		Page<Object> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> insert(@RequestBody ProductDto dto) {
		dto=  service.insertProduct(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto dto){
		dto = service.updateProduct(id, dto);
		return ResponseEntity.ok(dto);
	}
}
