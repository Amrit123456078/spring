package com.exampal.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exampal.demo.DTO.Category;
import com.exampal.demo.DTO.Product;
import com.exampal.demo.Repository.CategoryRepository;
import com.exampal.demo.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public List<Product> searchProducts(String q) {
    return productRepository.findByNameContainingIgnoreCase(q);
  }

  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public List<Product> getProductsByCategory(String name) {
    Category category = categoryRepository.findByName(name);
    return productRepository.findByCategory(category);
  }

  @Override
  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product updateProduct(Long id, Product product) {
    Product existingProduct = productRepository.findById(id).orElse(null);
    if (existingProduct == null) {
      return null;
    }
    existingProduct.setName(product.getName());
    existingProduct.setDescription(product.getDescription());
    existingProduct.setPrice(product.getPrice());
    existingProduct.setCategory(product.getCategory());
    return productRepository.save(existingProduct);
  }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
