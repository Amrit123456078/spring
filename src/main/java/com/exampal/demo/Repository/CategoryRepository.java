package com.exampal.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.demo.DTO.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
}
