package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.entity.Panier;
import org.springframework.data.repository.CrudRepository;

public interface PanierRepo extends CrudRepository<Panier, Integer> {
}
