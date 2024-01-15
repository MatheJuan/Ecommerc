package com.devlpjruan.ecommercproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlpjruan.ecommercproject.entities.User;
import com.devlpjruan.ecommercproject.services.exceptions.ForbiddenException;

@Service
public class AuthServices {
	
	@Autowired
	private UserService userService;
	
	public void validateSelfOrAdmin(long idUser) {
		User mim = userService.authenticated();
		
		if(!mim.hasRole("ROLE_ADMIN") && !mim.getId().equals(idUser)) {
			throw new ForbiddenException("Acess denied");
		}
	}
}
