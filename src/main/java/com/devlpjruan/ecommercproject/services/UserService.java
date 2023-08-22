package com.devlpjruan.ecommercproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.devlpjruan.ecommercproject.dto.UserDto;
import com.devlpjruan.ecommercproject.entities.Role;
import com.devlpjruan.ecommercproject.entities.User;
import com.devlpjruan.ecommercproject.projections.UserDetailsProjection;
import com.devlpjruan.ecommercproject.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service	
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);
		if(result.size()==0) {
			throw new UsernameNotFoundException("Email not found.");
		}
		User user = new User();
		user.setEmail(result.get(0).getUsername());
		user.setPassword(result.get(0).getPassword());
		for(UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}
		return user;
	}
	
	protected User authenticated() {
		try {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
		String username = jwtPrincipal.getClaim("username");

		
		Optional<User> user = userRepository.findByEmail(username);
		return user.get();
		
		}catch (Exception e) {
			throw new UsernameNotFoundException("Email nao encontrado");
		}
	}
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public UserDto getLogin() {
		User user = authenticated();
		
		return new UserDto(user);
	}

}
