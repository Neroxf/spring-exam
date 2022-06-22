package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
