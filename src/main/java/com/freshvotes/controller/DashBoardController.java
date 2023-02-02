package com.freshvotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.freshvotes.model.Product;
import com.freshvotes.model.User;
import com.freshvotes.repository.ProductRepository;

@Controller
public class DashBoardController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/")
	public String rootView() {
		return "index";
	}	
	
	@GetMapping(value = "/dashboard")
	private String dashboard(ModelMap model) {
		List<Product> products = productRepository.findAll();
		model.put("products", products);
		return "dashboard";
	}

}
