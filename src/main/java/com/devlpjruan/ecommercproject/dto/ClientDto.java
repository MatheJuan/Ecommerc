package com.devlpjruan.ecommercproject.dto;

import com.devlpjruan.ecommercproject.entities.User;

public class ClientDto {
	private Long id;
	private String name;
	
	public ClientDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ClientDto() {
		super();
	}
	public ClientDto(User entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
