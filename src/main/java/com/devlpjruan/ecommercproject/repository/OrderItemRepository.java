package com.devlpjruan.ecommercproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devlpjruan.ecommercproject.entities.OrdemItemPK;
import com.devlpjruan.ecommercproject.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPK>{

}
