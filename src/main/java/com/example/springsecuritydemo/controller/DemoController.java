package com.example.springsecuritydemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class DemoController {


    @GetMapping("/")
    public String showHome(Principal principal){
        System.out.println(principal.getName());

        return "home";
    }


    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
}
