package com.freshvotes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freshvotes.model.Feature;
import com.freshvotes.model.User;
import com.freshvotes.model.Vote;
import com.freshvotes.model.VoteId;
import com.freshvotes.repository.VoteRepository;
import com.freshvotes.service.FeatureService;
import com.freshvotes.service.ProductService;

@Controller
public class VoteController {
	
	@Autowired
	private FeatureService featureService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private VoteRepository voteRepository;
	
	@RequestMapping(value = "/votes", method = RequestMethod.GET)
	public String getFeatures(ModelMap model, @AuthenticationPrincipal User user){
		List<Feature> features = featureService.findAll();
		model.put("features", features);
		model.put("user", user);
		model.put("vote", new Vote());
		return "votes";
	}
	
	@RequestMapping(value = "/votes/{featureId}/{userId}", method = RequestMethod.POST)
	public String upVote(@PathVariable Long featureId, @AuthenticationPrincipal User user,
			@ModelAttribute Vote vote) {
		
		//System.out.println(vote.getUpvote());
		VoteId voteId = new VoteId();
		Optional<Feature> optionalFeature = featureService.findById(featureId);
		
		if(optionalFeature.isPresent()) {
			voteId.setFeature(optionalFeature.get());
		}
		
		voteId.setUser(user);
		vote.setPk(voteId);
		vote.setUpvote(vote.getUpvote());
		voteRepository.save(vote);
		
		return "redirect:/votes";
	}

}
