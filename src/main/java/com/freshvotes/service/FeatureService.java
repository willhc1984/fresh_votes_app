package com.freshvotes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshvotes.model.Feature;
import com.freshvotes.model.Product;
import com.freshvotes.repository.FeatureRepository;
import com.freshvotes.repository.ProductRepository;

@Service
public class FeatureService {
	
	@Autowired
	private FeatureRepository featureRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Feature createFeature(Long productId) {
		Feature feature = new Feature();
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {
			feature.setProduct(optionalProduct.get());
			feature.setStatus("Pending review");
			return featureRepository.save(feature);
		}

		return feature;
	}

	public Feature save(Feature feature) {
		return featureRepository.save(feature);
	}

	public Optional<Feature> findById(Long featureId) {
		return featureRepository.findById(featureId);
	}

}
