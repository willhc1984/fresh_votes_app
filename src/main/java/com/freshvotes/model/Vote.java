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
	
	public VoteId getPk() {
		return pk;
	}
	public void setPk(VoteId pk) {
		this.pk = pk;
	}
	public Boolean getUpvote() {
		return upvote;
	}
	public void setUpvote(Boolean upvote) {
		this.upvote = upvote;
	}
	
	@Override
	public String toString() {
		return "Vote [pk=" + pk + ", upvote=" + upvote + "]";
	}
	
	
	
}
