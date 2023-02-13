package com.freshvotes.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freshvotes.model.Feature;
import com.freshvotes.model.Product;
import com.freshvotes.model.User;
import com.freshvotes.repository.ProductRepository;
import com.freshvotes.service.ProductService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;


@Controller
public class ProductController {
	
	private Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/products")
	public String createProduct(ModelMap model) {
		model.put("product", new Product());
		return "addProduct";
	}
	
	@PostMapping(value = "/products")
	private String createProduct(@Valid @ModelAttribute Product product, BindingResult result,
			RedirectAttributes attr, Model model,
			@AuthenticationPrincipal User user) {
		
		if(result.hasErrors()) {
			attr.addFlashAttribute("fail", "Name is mandatory.");
			return "redirect:/products";
		}
		
		product.setPublished(false);
		product.setUser(user);
		
		productRepository.save(product);
		return "redirect:/dashboard/";
	}
	
	
	@GetMapping(value = "/products/{productId}/features")
	public String createFeature (ModelMap model, @PathVariable Long productId) {
		Product product = productRepository.getById(productId);
		model.put("feature", new Feature());
		model.put("product", product);
		return "addFeature";
	}
	
	@GetMapping(value = "/products/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse response) throws IOException{
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			model.put("product", product);
		}else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + productId + " not found!");
			return "product";
		}
		return "product";
	}
	
	@PostMapping(value = "/products/{productId}")
	public String saveProduct(@PathVariable Long productId, Product product) {	
		productRepository.save(product);
		return "redirect:/dashboard/";
	}
	
	@GetMapping("/p/{productName}")
	public String productUserView(@PathVariable String productName, ModelMap model) {
		if(productName != null) {
			try {
				String decodedProductName = URLDecoder.decode(productName, StandardCharsets.UTF_8.name());
				Optional<Product> optionalProduct = productRepository.findByName(decodedProductName);
				if(optionalProduct.isPresent()) {
					model.put("product", optionalProduct.get());
				}
			} catch (UnsupportedEncodingException e) {
				log.error("There was an error decoding a product URL", e);
				System.out.println("eita...");
			}	
		}
		return "productUserView";
	}
	
	@GetMapping(value = "/product/{idProduct}")
	public String deleteProductById(@PathVariable Long id) {
		productService.deleteById(id);
		return "dashboard";
	}

}
