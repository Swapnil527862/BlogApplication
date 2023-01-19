package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.Entities.Category;
import com.blog.Service.CategoryService;
import com.blog.payLoad.CategoryDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/categories/")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("{catid}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer  catid){
		CategoryDto updateCategory = this.categoryService.updatecategory(categoryDto, catid);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	
	@DeleteMapping("{catid}")
	public ResponseEntity<CategoryDto> deleteCategory(@PathVariable Integer catid){
		Category deleteCategory = this.categoryService.delete(catid);
		return new ResponseEntity<CategoryDto>(HttpStatus.CREATED);
	}
	
	@GetMapping("{catid}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catid){
		CategoryDto getCategory = this.categoryService.getcatagoryById(catid);
		return new ResponseEntity<CategoryDto>(getCategory,HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> getAllCategory = this.categoryService.getAllCategories();
		return ResponseEntity.ok(getAllCategory);
	}
	
	

}
