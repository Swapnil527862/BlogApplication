package com.blog.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Entities.Category;
import com.blog.Exception.ResourceNotFoundException;
import com.blog.Repository.CategoryRepo;
import com.blog.Service.CategoryService;
import com.blog.payLoad.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category Addcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(Addcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updatecategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException());
		cat.setCatagoryDescription(categoryDto.getCatagoryDescription());
		cat.setCatagoryTitle(categoryDto.getCatagoryTitle());

		Category Updatecat = this.categoryRepo.save(cat);

		return this.modelMapper.map(Updatecat, CategoryDto.class);
	}

	@Override
	public Category delete(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException());
		this.categoryRepo.delete(cat);
		return cat;

	}

	@Override
	public CategoryDto getcatagoryById(Integer categoryId) {
		Optional<Category> cat = Optional
				.ofNullable(this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException()));
		CategoryDto map = this.modelMapper.map(cat, CategoryDto.class);

		return map;
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = this.categoryRepo.findAll();

		List<CategoryDto> catDTO = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());

		return catDTO;
	}

}
