package com.freshvotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshvotes.model.Product;
import com.freshvotes.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findByPublished(Boolean bool){
		return productRepository.findByPublished(bool);
	}

}
