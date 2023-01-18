package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freshvotes.model.UserModel;
import com.freshvotes.repository.UserRepository;
import com.freshvotes.security.CustomSecurityUser;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepository.findByUsername(username);
		if(userModel == null) {
			throw new UsernameNotFoundException("Ivalid Username and password!");
		}
		return new CustomSecurityUser(userModel);
	}

}
