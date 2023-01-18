package com.freshvotes.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_votes")
public class VoteModel {
	
	@EmbeddedId
	private VoteModelId pk;
	private Boolean upvote;
	
	public Boolean getUpvote() {
		return upvote;
	}
	public void setUpvote(Boolean upvote) {
		this.upvote = upvote;
	}
	
	

}
