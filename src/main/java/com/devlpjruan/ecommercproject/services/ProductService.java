package com.devlpjruan.ecommercproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devlpjruan.ecommercproject.dto.CategoryDto;
import com.devlpjruan.ecommercproject.dto.ProductDto;
import com.devlpjruan.ecommercproject.dto.ProductMinDto;
import com.devlpjruan.ecommercproject.entities.Category;
import com.devlpjruan.ecommercproject.entities.Product;
import com.devlpjruan.ecommercproject.repository.ProductRepository;
import com.devlpjruan.ecommercproject.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public ProductDto findById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ProductDto(product);
	}
	
	@Transactional(readOnly = true)
	public Page<ProductMinDto> findAll(String name, Pageable pageable) {
		Page<Product> result = (Page<Product>) productRepository.searchByName(name	, pageable);
		return result.map(x -> new ProductMinDto(x));
	}
	
	@Transactional
	public ProductDto insertProduct(ProductDto dto) {
		
		Product entity = new Product();
		DtoToEntity(dto, entity);
		entity = productRepository.save(entity);
		return new ProductDto(entity);
	}
	@Transactional
	public ProductDto updateProduct(Long id, ProductDto dto) {
		try {
		Product entity = productRepository.getReferenceById(id);
		DtoToEntity(dto, entity);
		entity = productRepository.save(entity);
		return new ProductDto(entity);
		
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
	}
	
	private void DtoToEntity(ProductDto dto, Product entity){
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgurl());
		entity.getCategories().clear();
		for(CategoryDto catDto : dto.getCategoryList()) {
			Category cat = new Category();
			cat.setId(catDto.getId());
			entity.getCategories().add(cat);
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!productRepository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
			
		}try {
		 productRepository.deleteById(id);
		 
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
			
		}
	}
	
}
