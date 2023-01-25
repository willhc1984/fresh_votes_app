package com.freshvotes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String getFeature(ModelMap model, @PathVariable Long featureId, @PathVariable Long productId) {
		Optional<Feature> optionalFeature = featureService.findById(featureId);
		if(optionalFeature.isPresent()){
			model.put("feature", optionalFeature.get());
		}
		
		return "feature";
	}
	
	@PostMapping(value = "/{featureId}")
	public String updateFeature(Feature feature, @PathVariable Long productId, @PathVariable Long featureId) {
		feature = featureService.save(feature);
		return "redirect:/products/"+productId+"/features/"+feature.getId();
	}
	
	

}
