package com.devlpjruan.ecommercproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devlpjruan.ecommercproject.entities.Role;
import com.devlpjruan.ecommercproject.entities.User;
import com.devlpjruan.ecommercproject.projections.UserDetailsProjection;
import com.devlpjruan.ecommercproject.repository.UserRepository;

@Service	
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	
	/**
	 *
	 */
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

}
