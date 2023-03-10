package com.blog.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column(name = "post_title",nullable = false)
	private String title;
	private String comment;
	private String imageName;
	private Date addDate;
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private Set<Comment>comments= new HashSet<>();
	@ManyToOne
	private User user;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date date) {
		this.addDate = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Post(int postId, String title, String comment, String imageName, Date addDate, User user,
			Category category) {
		super();
		this.postId = postId;
		this.title = title;
		this.comment = comment;
		this.imageName = imageName;
		this.addDate = addDate;
		this.user = user;
		this.category = category;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Post(int postId, String title, String comment, String imageName, Date addDate, Set<Comment> comments,
			User user, Category category) {
		super();
		this.postId = postId;
		this.title = title;
		this.comment = comment;
		this.imageName = imageName;
		this.addDate = addDate;
		this.comments = comments;
		this.user = user;
		this.category = category;
	}
	
	
	

}
