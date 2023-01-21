package com.blog.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.blog.Entities.Category;
import com.blog.Entities.Post;
import com.blog.Entities.User;
import com.blog.Exception.ResourceNotFoundException;
import com.blog.Repository.CategoryRepo;
import com.blog.Repository.PostRepo;
import com.blog.Repository.UserRepo;
import com.blog.Service.PostService;
import com.blog.payLoad.PostDto;
import com.blog.payLoad.PostResponce;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found user " + userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found category id " + categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setCategory(category);
		post.setUser(user);

		Post newPost = this.postRepo.save(post);

		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("User doesnt exist in update" + postId));
		post.setTitle(postDto.getTitle());
		post.setComment(postDto.getComment());
		Post upadatedpost = this.postRepo.save(post);

		return this.modelMapper.map(upadatedpost, PostDto.class);
	}

	@Override
	public void deletepost(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("User doesnt exist" + postId));
		this.postRepo.delete(post);
	}

	@Override
	public PostResponce getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir) {
		
		Sort sort=null;
		if (sortDir.equalsIgnoreCase("asc")) {
			
			sort= Sort.by(sortBy).ascending();
			
		}else {
			sort= Sort.by(sortBy).descending();
		}
		
		
		Pageable p=PageRequest.of(pageSize, pageSize, sort)	;
		Page<Post> pagePost = this.postRepo.findAll(p);
		
		List<Post> Allpost = pagePost.getContent();
		List<PostDto> allPostDto = Allpost.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		PostResponce postResponce= new PostResponce();
		
postResponce.setContent(allPostDto);
postResponce.setPageNumber(pagePost.getNumber());
postResponce.setTotalElements(pagePost.getTotalElements());
postResponce.setPageSize(pagePost.getSize());
postResponce.setTotalPage(pagePost.getTotalPages());
postResponce.setLastPage(pagePost.isLast());



		return postResponce;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found By id" + postId));
		PostDto map = this.modelMapper.map(post, PostDto.class);
		return map;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found category" + categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postdtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer UserId) {
		User user = this.userRepo.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User is not found" + UserId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postdtos;
	}

	@Override
	public List<PostDto> serachPosts(String keyword) {
List<Post> posts = this.postRepo.findByTitleContaining(keyword);
List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
