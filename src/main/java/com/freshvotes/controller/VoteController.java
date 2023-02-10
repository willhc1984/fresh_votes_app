package com.freshvotes.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/votesPaginated", method = RequestMethod.GET)
	public String getFeaturesPaginated(
			 	@AuthenticationPrincipal User user,
				ModelMap model,
				@RequestParam("page") Optional<Integer> page,
				@RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(7);
		
		Page<Feature> featurePage = featureService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
		
		model.addAttribute("featurePage", featurePage);
		model.put("user", user);
		model.put("features", featurePage);
		
		int totalPages = featurePage.getTotalPages();
		
		if(totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		return "votesPageable";
		
	}
	
	@RequestMapping(value = "/votes/{featureId}/{userId}", method = RequestMethod.POST)
	public String upVote(@PathVariable Long featureId, @AuthenticationPrincipal User user,
			@ModelAttribute Vote vote, RedirectAttributes attr) {
		
		VoteId voteId = new VoteId();
		Optional<Feature> optionalFeature = featureService.findById(featureId);
		
		if(optionalFeature.isPresent()) {
			voteId.setFeature(optionalFeature.get());
		}
		
		voteId.setUser(user);
		vote.setPk(voteId);
		voteRepository.save(vote);
		
		attr.addFlashAttribute("success", "Confirmed vote!");
		return "redirect:/votesPaginated";
	}

}
