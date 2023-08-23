package com.devlpjruan.ecommercproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlpjruan.ecommercproject.dto.CategoryDto;
import com.devlpjruan.ecommercproject.entities.Category;
import com.devlpjruan.ecommercproject.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
 
	@Transactional(readOnly = true)
	public List<CategoryDto> findAll() {
		List<Category> result = repository.findAll();
		return result.stream().map(x -> new CategoryDto(x)).toList();
	}
}
