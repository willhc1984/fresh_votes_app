package com.freshvotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshvotes.model.Feature;
import com.freshvotes.service.FeatureService;

@Controller
@RequestMapping(value = "/products/{productId}/features")
public class FeatureController {
	
	@Autowired
	private FeatureService featureService;
	
	@PostMapping
	public String createFeature(@PathVariable Long productId) {
		Feature feature = featureService.createFeature(productId);
		return "redirect:/products/"+productId+"/features/"+feature.getId();
	}
	
	@GetMapping(value = "/{featureId}")
	public String getFeature(@PathVariable Long featureId, @PathVariable Long productId) {
		return "feature";
		
	}
	
	

}
