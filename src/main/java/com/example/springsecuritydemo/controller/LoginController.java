package com.example.springsecuritydemo.controller;


import com.example.springsecuritydemo.entity.Authorities;
import com.example.springsecuritydemo.entity.Users;
import com.example.springsecuritydemo.repository.AuthoritiesRepo;
import com.example.springsecuritydemo.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/login")
public class LoginController {
    @Autowired
    private AuthoritiesRepo authoritiesRepo ;
    @Autowired
    private UsersRepo usersRepo ;


    @PostMapping("/login")
    public Users showMyLoginPage(@RequestParam String username, @RequestParam String password){
        Users user = usersRepo.findById(username).orElse(null);

        if(user != null){
            if(user.getPassword()== password)
                return user;
        }
        return null;
    }

    @PostMapping("/register")
    public void showAccessDenied(@RequestBody Users user){
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(new Authorities(user.getUsername(),"ROLE_USER" ));
        user.setAuthorities(authorities);
        user.setLocked(true);
        user.setEnabled((byte) 1);
        usersRepo.save(user);
    }

}
