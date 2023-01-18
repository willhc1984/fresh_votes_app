package com.freshvotes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comments")
public class CommentModel{
	
	@EmbeddedId
	private CommentModelId pk;
	@Column(length = 5000)
	private String Text;
	
	public CommentModelId getPk() {
		return pk;
	}
	public void setPk(CommentModelId pk) {
		this.pk = pk;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	
	

}
