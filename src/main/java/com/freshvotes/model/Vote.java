package com.freshvotes.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_votes")
public class Vote {
	
	@EmbeddedId
	private VoteId pk;
	private Boolean upvote;
	
	public Boolean getUpvote() {
		return upvote;
	}
	public void setUpvote(Boolean upvote) {
		this.upvote = upvote;
	}
	
	

}
