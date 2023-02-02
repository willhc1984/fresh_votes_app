package com.freshvotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.model.User;
import com.freshvotes.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register(ModelMap model) {
		model.put("user",  new User());
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String registerPost(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:login";
	}
	
	@GetMapping(value = "/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

}
