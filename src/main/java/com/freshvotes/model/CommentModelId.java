package com.freshvotes.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CommentModelId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private UserModel user;
	@ManyToOne
	private FeatureModel feature;
	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public FeatureModel getFeature() {
		return feature;
	}
	public void setFeature(FeatureModel feature) {
		this.feature = feature;
	}
	
	

}
