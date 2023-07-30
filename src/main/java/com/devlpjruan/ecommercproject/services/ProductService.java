package com.devlpjruan.ecommercproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional(readOnly = true)
	public Page<Object> findAll(Pageable pageable) {
		Page<Product> result = productRepository.findAll(pageable);
		return result.map(x -> new ProductDto(x));
	}
	
	@Transactional
	public ProductDto insertProduct(ProductDto dto) {
		
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgurl(dto.getImgurl());
		
		entity = productRepository.save(entity);
		return new ProductDto(entity);
	}
}
