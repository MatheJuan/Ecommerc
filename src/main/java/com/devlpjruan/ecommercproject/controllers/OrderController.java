package com.devlpjruan.ecommercproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlpjruan.ecommercproject.dto.OrderDto;
import com.devlpjruan.ecommercproject.services.OrderService;

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
 	
	
}
