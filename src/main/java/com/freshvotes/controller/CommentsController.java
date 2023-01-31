package com.freshvotes.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freshvotes.model.Comment;
import com.freshvotes.model.Feature;
import com.freshvotes.model.User;
import com.freshvotes.repository.CommentRepository;
import com.freshvotes.repository.FeatureRepository;

@Controller
@RequestMapping(value = "/products/{productId}/features/{featureId}/comments")
public class CommentsController {
	
	@Autowired
	public CommentRepository commentRepository;
	
	@Autowired
	public FeatureRepository featureRepository;
	
	@GetMapping
	@ResponseBody
	public List<Comment> getComment(@PathVariable Long featureId){		
		List<Comment> findByFeatureId = commentRepository.findByFeatureId(featureId);
		return findByFeatureId;
	}
	
	@PostMapping("")
	public String postComment(@AuthenticationPrincipal User user, Comment comment, 
			@PathVariable Long featureId, @PathVariable Long productId) {
		Optional<Feature> optionalFeature = featureRepository.findById(featureId);
		
		if(optionalFeature.isPresent()) {
			comment.setFeature(optionalFeature.get());
			comment.setUser(user);
			comment.setCreatedDate(new Date());
		}
			
		commentRepository.save(comment);
			
		return "redirect:/products/"+ productId + "/features/" + featureId;
	}

}
