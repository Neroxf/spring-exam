package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.entity.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeRepo extends CrudRepository<Commande, Integer> {

    List<Commande> findAllByUser(String username);
}
