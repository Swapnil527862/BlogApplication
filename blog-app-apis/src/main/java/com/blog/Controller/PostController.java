package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Entities.Post;
import com.blog.Service.PostService;
import com.blog.config.AppConstants;
import com.blog.payLoad.ApiResponce;
import com.blog.payLoad.PostDto;
import com.blog.payLoad.PostResponce;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
// get by user 
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getpostByUser(@PathVariable Integer userId) {
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	// get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	// get All pos
	@GetMapping("/posts")
	public ResponseEntity<PostResponce> getAllPosts(@RequestParam
			(value = "pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue =AppConstants.PAGE_SIZE,required = false) Integer pageSize
	,@RequestParam (value = "sortBy",defaultValue =AppConstants.SORT_BY,required = false)String sortBy,
	@RequestParam (value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false)String sortDir ){	
		 PostResponce postResponce = this.postService.getAllPost(pageSize, pageSize, sortBy,sortDir);
		return new ResponseEntity<PostResponce>(postResponce,HttpStatus.OK);
		
	}
	// get post by id 
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getpostById(@PathVariable Integer postId){
		PostDto postdto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postdto,HttpStatus.OK);
	}
	//update 
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) {
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK );
	}
	//delete
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponce deletePost(@PathVariable Integer postId) {
		this.postService.deletepost(postId);
		return new ApiResponce("Post sucessfully deleted", true);
	}
	// search
	
	@GetMapping("/posts/search/{keywords}")	
	public ResponseEntity<List<PostDto>>searchPostByTitle(@PathVariable String keywords){
		
		List<PostDto> result = this.postService.serachPosts(keywords);
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
		
	}
}
