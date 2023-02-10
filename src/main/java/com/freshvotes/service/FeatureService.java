package com.freshvotes.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Feature> findPaginated(Pageable pageable){
		
		List<Feature> features = featureRepository.findAll();
		
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Feature> list = null;
		
		if(features.size() < startItem) {
			features = Collections.emptyList();
		}else {
			int toIndex = Math.min(startItem + pageSize, features.size());
			list = features.subList(startItem, toIndex);
		}
		
		Page<Feature> featurePage = new PageImpl<Feature>(list, PageRequest.of(currentPage, pageSize), features.size());
		
		return featurePage;
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
