package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.entity.*;
import com.example.springsecuritydemo.repository.AuthoritiesRepo;
import com.example.springsecuritydemo.repository.CategoryRepo;
import com.example.springsecuritydemo.repository.ProductRepo;
import com.example.springsecuritydemo.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private AuthoritiesRepo authoritiesRepo;


    @GetMapping("/list")
    public List<Users> showUsers(){
        return  (List<Users>) usersRepo.findAll();
    }

    @GetMapping("/list/{userId}")
    public Users showUser(@PathVariable String userId){
        return usersRepo.findById(userId).orElse(null);
    }



    @PostMapping("/saveUser")
    public Users saveUser(@RequestBody Users user){

        List<Authorities> authorities = new ArrayList<>();
        authorities.add(new Authorities(user.getUsername(),"ROLE_USER" ));
        user.setAuthorities(authorities);
        user.setLocked(true);
        usersRepo.save(user);

//        return "list-customer";
        return user;
    }


    @PutMapping("/saveUser")
    public Users updateUser(@RequestBody Users user){
        usersRepo.save(user);
        return user;
    }




    @DeleteMapping("/deleteUser/{userId}")
    public boolean deleteUser(@PathVariable String userId){
        Users user = usersRepo.findById(userId).orElse(null);
        authoritiesRepo.deleteAll(user.getAuthorities());
        usersRepo.deleteById(userId);

        return true;
    }
}
