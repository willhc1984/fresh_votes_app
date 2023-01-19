package com.freshvotes.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.freshvotes.model.UserModel;

public class CustomSecurityUser extends UserModel implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	public CustomSecurityUser() {
		
	}

	public CustomSecurityUser(UserModel userModel) {
		this.setAuthorities(userModel.getAuthorities());
		this.setId(userModel.getId());
		this.setName(userModel.getUsername());
		this.setPassword(userModel.getPassword());
		this.setUsername(userModel.getUsername());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
