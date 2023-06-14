package com.exampal.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exampal.demo.DTO.Category;
import com.exampal.demo.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Category getCategoryById(Long id) {
    return categoryRepository.findById(id).orElse(null);
  }

  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public Category addCategory(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public Category updateCategory(Long id, Category category) {
    Category existingCategory = categoryRepository.findById(id).orElse(null);
    if (existingCategory == null) {
      return null;
    }
    existingCategory.setName(category.getName());
    existingCategory.setDescription(category.getDescription());
    return categoryRepository.save(existingCategory);
  }

  @Override
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }
}
