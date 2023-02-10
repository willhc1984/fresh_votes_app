package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshvotes.model.Feature;
import com.freshvotes.model.User;
import com.freshvotes.model.Vote;
import com.freshvotes.repository.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	private VoteRepository voteRepository;
	
	


}
