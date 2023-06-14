package com.exampal.demo.service;

import java.util.List;

import com.exampal.demo.DTO.Category;
import com.exampal.demo.DTO.Product;

public interface ProductService {
	  Product getProductById(Long id);
	  List<Product> getAllProducts();
	  List<Product> searchProducts(String q);
	  List<Category> getAllCategories();
	  List<Product> getProductsByCategory(String name);
	  Product addProduct(Product product);
	  Product updateProduct(Long id, Product product);
	  void deleteProduct(Long id);
	}

