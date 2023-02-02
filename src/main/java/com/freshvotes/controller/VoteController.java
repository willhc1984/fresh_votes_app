package com.freshvotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.freshvotes.repository.ProductRepository;

@Controller
public class VoteController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/votes")
	public String votes() {
		return "votes";
	}	

}
