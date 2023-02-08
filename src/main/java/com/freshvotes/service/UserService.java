package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freshvotes.model.User;
import com.freshvotes.repository.UserRepository;
import com.freshvotes.security.Authority;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void save(User user) {		
		user.setPassword(passwordEncoder.encode(user.getPassword()));			
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		user.getAuthorities().add(authority);
			
		userRepository.save(user);
	}

}
