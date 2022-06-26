package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.entity.Category;
import com.example.springsecuritydemo.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> findAllByCategory(Category category);

    List<Product> findAllByNameContaining(String name);

}
