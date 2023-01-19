package com.blog.Service;

import java.util.List;

import com.blog.Entities.Category;
import com.blog.payLoad.CategoryDto;

public interface CategoryService {
	
	//create public 
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update 
	
	CategoryDto updatecategory(CategoryDto categoryDto, Integer categoryId);
	
	Category delete(Integer categoryId);
	
	CategoryDto getcatagoryById(Integer categoryId);
	
	List<CategoryDto> getAllCategories();
	

}
