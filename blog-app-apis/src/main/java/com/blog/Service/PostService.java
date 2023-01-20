package com.blog.Service;

import java.util.List;

import com.blog.Entities.Post;
import com.blog.payLoad.PostDto;

public interface PostService {

	// create method of post
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	PostDto  updatePost(PostDto postDto, Integer postId);
	
	void deletepost(Integer postId);
	//Get all post
	List<PostDto>  getAllPost();
	//get post by id
	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	//post serch by user
	List<PostDto> getPostByUser(Integer UserId);
	//searching
	List<Post> serachPosts(String keyword);
	
	
}
