package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UsersRepo extends CrudRepository<Users, String> {
}
