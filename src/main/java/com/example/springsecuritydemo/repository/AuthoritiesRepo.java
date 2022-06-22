package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.entity.Authorities;
import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepo extends CrudRepository<Authorities, Integer> {

}
