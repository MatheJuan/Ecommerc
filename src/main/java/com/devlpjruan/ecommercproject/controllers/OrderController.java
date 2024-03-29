package com.devlpjruan.ecommercproject.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devlpjruan.ecommercproject.dto.OrderDto;
import com.devlpjruan.ecommercproject.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDto> findByid(@PathVariable Long id) {
		OrderDto dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
		
	
	@PreAuthorize("hasAnyRole('ROLE_CLIENT')")
	@GetMapping
	public ResponseEntity<OrderDto> insert(@Valid @RequestBody OrderDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	
}
