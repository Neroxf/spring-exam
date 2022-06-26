package com.example.springsecuritydemo.controller;


import com.example.springsecuritydemo.entity.Category;
import com.example.springsecuritydemo.entity.Commande;
import com.example.springsecuritydemo.entity.Product;
import com.example.springsecuritydemo.entity.Users;
import com.example.springsecuritydemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/front")
public class FrontController {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private PanierRepo panierRepo;

    @Autowired
    private CommandeRepo commandeRepo;

    @Autowired
    private UsersRepo usersRepo;


    @GetMapping("/products")
    public List<Product> showProductss(@RequestParam("search") String search){
        System.out.println(search);
        List<Product> products = productRepo.findAllByNameContaining(search);
        return products;
    }


    @GetMapping("/list")
    public String showProducts(Model model){
        List<Category> categories = (List<Category>) categoryRepo.findAll();

        model.addAttribute("categories", categories);

        return "list-category";
    }

    @GetMapping("showProducts")
    public String showProducts(@RequestParam("categoryId") int id, Model model){


        List<Product> products = productRepo.findAllByCategory(categoryRepo.findById(id).orElse(null));

        model.addAttribute("products", products);

        return "productss";
    }

    @GetMapping("search")
    public String showProduct(){
        return "search";
    }


/*    @RequestMapping("addCommande")
    public String addproduct(@RequestParam("productId") int id, Principal principal){
        Users user = usersRepo.findById(principal.getName()).orElse(null);
        Product product = productRepo.findById(id).orElse(null);
        commandeRepo.save(new Commande(user, product, 1));

        return "redirect:/front/list";
    }*/


}















