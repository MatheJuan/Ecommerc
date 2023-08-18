package com.devlpjruan.ecommercproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlpjruan.ecommercproject.dto.OrderDto;
import com.devlpjruan.ecommercproject.entities.Order;
import com.devlpjruan.ecommercproject.repository.OrderRepository;
import com.devlpjruan.ecommercproject.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public OrderDto findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso nao encontrado"));
		return new OrderDto(order);
	}
}
