package com.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SystemSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth
//			.userDetailsService(userDetailService)
//			.passwordEncoder(getPasswordEncoder());
		auth.inMemoryAuthentication()
			.passwordEncoder(getPasswordEncoder())
			.withUser("jose@hotmail.com")
			.password(getPasswordEncoder().encode("123456"))
			.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http
	        .authorizeRequests()
	        	.antMatchers("/h2-console/**").permitAll()
	        	.antMatchers("/").permitAll()
	        	.anyRequest().hasRole("USER").and()
	        .formLogin()
	        	.loginPage("/login")
	        	.permitAll()
	        	.and()
	        .logout()
	        	.logoutUrl("/logout")
	        	.permitAll();
	}
	
}
