package com.fresh_votes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comments")
public class Comment{
	
	@EmbeddedId
	private CommentId pk;
	@Column(length = 5000)
	private String Text;
	
	public CommentId getPk() {
		return pk;
	}
	public void setPk(CommentId pk) {
		this.pk = pk;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	
	

}
