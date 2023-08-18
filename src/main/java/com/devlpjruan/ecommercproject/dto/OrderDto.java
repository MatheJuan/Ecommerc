package com.devlpjruan.ecommercproject.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devlpjruan.ecommercproject.entities.Order;
import com.devlpjruan.ecommercproject.entities.OrderItem;
import com.devlpjruan.ecommercproject.entities.OrderStatus;

public class OrderDto {
	
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private ClientDto client;
	
	private PaymentDto payment;
	//private double total = totalFinal();
	
	private List<OrderItemDto> items = new ArrayList<>();

	public OrderDto(Long id, Instant moment, OrderStatus status, ClientDto client, PaymentDto payment) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
		//this.total= total;
	}
	public OrderDto(Order entity) {
		id = entity.getId();
		moment = entity.getMoment();
		status = entity.getStatus();
		client = new ClientDto(entity.getClient());
		payment = ((entity.getPayment()==null) ? null : new PaymentDto(entity.getPayment()));
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
	
	public double totalFinal() {
		double summ = 0.0;
		for(OrderItemDto dto : items) {
			summ += dto.getSubtotal();
		}return summ;
	}
	
	 
	
}
