package com.freshvotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String registerPost(@Valid @ModelAttribute User user, BindingResult result, 
			RedirectAttributes attr, Model model) {
		
		User existingUser = userService.findByUsername(user.getUsername());
		
		if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()) {
			attr.addFlashAttribute("fail", "There is already an account registered with the same email");
			return "redirect:/register";
		}
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "/register";
		}
		
		userService.save(user);
		attr.addFlashAttribute("success", "Registered account!");
		return "redirect:/login";
	
	}
	
	@GetMapping(value = "/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

}
