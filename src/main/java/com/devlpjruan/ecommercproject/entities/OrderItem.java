package com.devlpjruan.ecommercproject.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order_item")
public class OrderItem {
	
	@EmbeddedId
	private OrdemItemPK id= new OrdemItemPK();;
	
	private Integer quantity;
	
	private double price;

	public OrderItem() {
	}

	public OrderItem(Order order, Product prduct, Integer quantity, double price) {
		id.setOrder(order);
		id.setProduct(prduct);
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public OrdemItemPK getOrdemItemPK() {
		return id;
	}

	public void setOrdemItemPK(OrdemItemPK id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public void getOrder(Order order) {
		 id.setOrder(order);
	}
	public Order getOrder() {
		return id.getOrder();
	}
	public void setProduct(Product product) {
		 id.setProduct(product);
	}
	public Product getProduct() {
		return id.getProduct();
	}
	
}
