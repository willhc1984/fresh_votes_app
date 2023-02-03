package com.freshvotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.freshvotes.model.Feature;
import com.freshvotes.service.FeatureService;
import com.freshvotes.service.ProductService;

@Controller
public class VoteController {
	
	@Autowired
	private FeatureService featureService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/votes")
	public String getFeatures(ModelMap model){
		List<Feature> features = featureService.findAll();
		model.put("features", features);
		return "votes";
	}

}
