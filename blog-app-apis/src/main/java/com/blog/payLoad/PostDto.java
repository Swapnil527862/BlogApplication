package com.blog.payLoad;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.Entities.Comment;


public class PostDto {	
	
	
	private String imageName;
	private Date addDate;
	  private UserDto user;
	  private CategoryDto category;
	  private Set<Comment> comments= new HashSet<>();
	  
	  
	public PostDto(String title, String comment) {
		super();
		this.title = title;
		this.comment = comment;
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
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
	private String title;
	private String comment;
	private Integer postId;
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public PostDto(Integer postId) {
		super();
		this.postId = postId;
	}
	
	public PostDto(String title, String comment, String imageName, Date addDate, UserDto user, CategoryDto category) {
		super();
		this.title = title;
		this.comment = comment;
		this.imageName = imageName;
		this.addDate = addDate;
		this.user = user;
		this.category = category;
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
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	 
}
