package com.exampal.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.demo.DTO.Category;
import com.exampal.demo.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingIgnoreCase(String q);

	List<Product> findByCategory(Category category);
}