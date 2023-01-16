package com.fresh_votes.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SystemSecurity  extends WebSecurityConfigurerAdapter{
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
        .and()
        .authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .and()
        .headers().frameOptions().disable()
        .and()
        .csrf().ignoringAntMatchers("/h2-console/**")
        .and()
        .cors().disable();
	}
	
}
