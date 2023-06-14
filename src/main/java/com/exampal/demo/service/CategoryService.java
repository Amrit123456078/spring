package com.exampal.demo.service;

import java.util.List;

import com.exampal.demo.DTO.Category;

public interface CategoryService {
	  Category getCategoryById(Long id);
	  List<Category> getAllCategories();
	  Category addCategory(Category category);
	  Category updateCategory(Long id, Category category);
	  void deleteCategory(Long id);
	}
