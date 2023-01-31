package com.freshvotes.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshvotes.model.Comment;
import com.freshvotes.model.Feature;
import com.freshvotes.model.User;
import com.freshvotes.service.FeatureService;

@Controller
@RequestMapping(value = "/products/{productId}/features")
public class FeatureController {
	
	@Autowired
	private FeatureService featureService;
	
	@PostMapping
	public String createFeature(@AuthenticationPrincipal User user, @PathVariable Long productId) {
		Feature feature = featureService.createFeature(productId, user);
		return "redirect:/products/"+productId+"/features/" + feature.getId();
	}
	
	@GetMapping(value = "/{featureId}")
	public String getFeature(@AuthenticationPrincipal User user, ModelMap model, @PathVariable Long featureId, @PathVariable Long productId) {
		Optional<Feature> optionalFeature = featureService.findById(featureId);
		
		if(optionalFeature.isPresent()){
			Feature feature = optionalFeature.get();
			model.put("feature", feature);
			SortedSet<Comment> commentsWithoutDuplicates = getCommentsWithoutDuplicates(0, new HashSet<Long>(), feature.getComments());
			model.put("thread", commentsWithoutDuplicates);
			model.put("comment", new Comment());
		}
		model.put("user", user);
		
		return "feature";
	}
	
	private SortedSet<Comment> getCommentsWithoutDuplicates(int page, Set<Long> visitedComments, SortedSet<Comment> comments) {
		page++;
		Iterator<Comment> itr = comments.iterator();
		while(itr.hasNext()) {
			Comment comment = itr.next();
			boolean addedToVisitedComments = visitedComments.add(comment.getId());
			if(!addedToVisitedComments) {
				itr.remove();
				if(page != 1) return comments;
			}
			if(addedToVisitedComments && !comment.getComments().isEmpty())
				getCommentsWithoutDuplicates(page, visitedComments, comment.getComments());
		}
		return comments;
	}

	@PostMapping(value = "/{featureId}")
	public String updateFeature(@AuthenticationPrincipal User user, Feature feature, @PathVariable Long productId, @PathVariable Long featureId) {
		feature.setUser(user);
		feature = featureService.save(feature);
		
		String encodedProductName;
		
		try {
			encodedProductName = URLEncoder.encode(feature.getProduct().getName(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "redirect:/dasboard";
		}
		
		return "redirect:/p/" + encodedProductName;
	}
	
	

}
