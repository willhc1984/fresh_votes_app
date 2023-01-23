package com.freshvotes.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.model.Product;
import com.freshvotes.model.User;
import com.freshvotes.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/products/{id}")
	public String getProduct(@PathVariable Long id, ModelMap model, HttpServletResponse response) throws IOException{
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			model.put("product", product);
		}else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + id + " not found!");
			return "product";
		}
		return "product";
	}
	
	@PostMapping(value = "/products/{id}")
	public String saveProduct(@PathVariable Long id, Product product) {	
		productRepository.save(product);
		return "redirect:/products/" + product.getId();

	}
	
	@PostMapping(value = "/products")
	private String createProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();
		
		product.setPublished(false);
		product.setUser(user);
		
		productRepository.save(product);
		return "redirect:/products/" + product.getId();
	}

}
