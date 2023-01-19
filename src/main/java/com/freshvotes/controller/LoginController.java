package com.freshvotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.model.UserModel;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String registerPost(@ModelAttribute UserModel userModel) {
		System.out.println(userModel.toString());
		return "redirect/login";
	}

}
