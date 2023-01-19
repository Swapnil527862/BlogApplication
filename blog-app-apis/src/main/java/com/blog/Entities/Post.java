package com.blog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column(name = "post_title",nullable = false)
	private String title;
	private String comment;
	private String imageNamel;
	private String addDate;

	@ManyToOne
	private User user;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	

}
