package com.freshvotes.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tb_comments")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Comment implements Comparable<Comment>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 5000)
	private String Text;
	@ManyToOne 
	@JsonIgnore
	private User user;
	@ManyToOne 
	@JsonIgnore
	private Feature feature;
	@OneToMany(mappedBy = "comment")
	@OrderBy("createdDate, id")
	private SortedSet<Comment> comments = new TreeSet<>();
	@ManyToOne
	@JoinColumn(name = "comment_id", nullable = true)
	@JsonIgnore
	private Comment comment;
	private Date createdDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
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
	public SortedSet<Comment> getComments() {
		return comments;
	}
	public void setComments(SortedSet<Comment> comments) {
		this.comments = comments;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date created_date) {
		this.createdDate = created_date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int compareTo(Comment that) {
		int comparedValue = this.createdDate.compareTo(that.createdDate);
		if(comparedValue == 0) {
			this.id.compareTo(that.id);
		}
		return comparedValue;
	}
	
	
}
