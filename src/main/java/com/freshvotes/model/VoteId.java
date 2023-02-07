package com.freshvotes.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Embeddable
public class VoteId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Feature feature;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	
	@Override
	public String toString() {
		return "VoteId [user=" + user + ", feature=" + feature + "]";
	}
	
	

}
