package com.devlpjruan.ecommercproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlpjruan.ecommercproject.dto.ProductDto;
import com.devlpjruan.ecommercproject.entities.Product;
import com.devlpjruan.ecommercproject.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public ProductDto findById(Long id) {
		Product product = productRepository.findById(id).get();
		return new ProductDto(product);
	}
}
