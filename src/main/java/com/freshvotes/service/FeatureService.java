package com.freshvotes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat.Features;
import com.freshvotes.model.Feature;
import com.freshvotes.model.Product;
import com.freshvotes.model.User;
import com.freshvotes.repository.FeatureRepository;
import com.freshvotes.repository.ProductRepository;

@Service
public class FeatureService {
	
	@Autowired
	private FeatureRepository featureRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Feature createFeature(Product product, User user, Feature feature) {
	
		feature.setProduct(product);
		feature.setStatus("Pending review");
		feature.setUser(user);
		user.getFeatures().add(feature);
		featureRepository.save(feature);
	
		return feature;
	}

	public Feature save(Feature feature) {
		return featureRepository.save(feature);
	}

	public Optional<Feature> findById(Long featureId) {
		return featureRepository.findById(featureId);
	}
	
	public List<Feature> findAll(){
		return featureRepository.findAll();
	}

}
