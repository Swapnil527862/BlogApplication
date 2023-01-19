package com.blog.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Column(length = 100,nullable = false)
	private String catagoryTitle;
	private String catagoryDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts= new ArrayList<>();
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCatagoryTitle() {
		return catagoryTitle;
	}
	public void setCatagoryTitle(String catagoryTitle) {
		this.catagoryTitle = catagoryTitle;
	}
	public String getCatagoryDescription() {
		return catagoryDescription;
	}
	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}
	public Category(int categoryId, String catagoryTitle, String catagoryDescription) {
		super();
		this.categoryId = categoryId;
		this.catagoryTitle = catagoryTitle;
		this.catagoryDescription = catagoryDescription;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


}
