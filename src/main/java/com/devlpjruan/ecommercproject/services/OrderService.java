package com.devlpjruan.ecommercproject.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devlpjruan.ecommercproject.dto.OrderDto;
import com.devlpjruan.ecommercproject.dto.OrderItemDto;
import com.devlpjruan.ecommercproject.entities.Order;
import com.devlpjruan.ecommercproject.entities.OrderItem;
import com.devlpjruan.ecommercproject.entities.OrderStatus;
import com.devlpjruan.ecommercproject.entities.Product;
import com.devlpjruan.ecommercproject.entities.User;
import com.devlpjruan.ecommercproject.repository.OrderItemRepository;
import com.devlpjruan.ecommercproject.repository.OrderRepository;
import com.devlpjruan.ecommercproject.repository.ProductRepository;
import com.devlpjruan.ecommercproject.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthServices  authServices;
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public OrderDto findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso nao encontrado"));
		authServices.validateSelfOrAdmin(order.getClient().getId());
		return new OrderDto(order);
	}
	@Transactional
	public OrderDto insert(OrderDto dto) {
		
		Order order = new Order();
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		
		User user= userService.authenticated();
		order.setClient(user);
		for(OrderItemDto itemDto : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDto.getProductId());
			OrderItem item = new OrderItem(order, product, itemDto.getQuatity(), product.getPrice());
			order.getItems().add(item);
		}
		repository.save(order);
		orderItemRepository.saveAll((order.getItems()));
		return new OrderDto(order);
	}
		
}
