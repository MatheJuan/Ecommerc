package com.devlpjruan.ecommercproject.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devlpjruan.ecommercproject.entities.Order;
import com.devlpjruan.ecommercproject.entities.OrderItem;
import com.devlpjruan.ecommercproject.entities.OrderStatus;

import jakarta.validation.constraints.NotEmpty;

public class OrderDto {
	
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private ClientDto client;
	
	private PaymentDto payment;
	//private double total = totalFinal();
	@NotEmpty(message = "O pedido deve ter pelo um item!")
	private List<OrderItemDto> items = new ArrayList<>();

	public OrderDto(Long id, Instant moment, OrderStatus status, ClientDto client, PaymentDto payment) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}
	public OrderDto(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.client = new ClientDto(entity.getClient());
		this.payment = (entity.getPayment()==null) ? null : new PaymentDto(entity.getPayment());
		for(OrderItem item : entity.getItems()) {
			OrderItemDto itemDto = new OrderItemDto(item);
			items.add(itemDto);
		}
	}
	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDto getClient() {
		return client;
	}

	public PaymentDto getPayment() {
		return payment;
	}

	public List<OrderItemDto> getItems() {
		return items;
	}
	
	public Double getTotal() {
		double summ = 0.0;
		for(OrderItemDto dto : items) {
			summ += dto.getSubtotal();
		}return summ;
	}
	
	 
	
}
