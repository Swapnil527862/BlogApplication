package com.blog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
//	private User user;
	@ManyToOne
	private Post post;
	public Comment(int id, String content, Post post) {
	super();
	this.id = id;
	this.content = content;
	this.post = post;
}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	

}
