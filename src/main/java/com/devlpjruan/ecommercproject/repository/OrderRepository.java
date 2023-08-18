package com.devlpjruan.ecommercproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devlpjruan.ecommercproject.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
}
