package com.example.springsecuritydemo.controller;


import com.example.springsecuritydemo.entity.*;
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

    @PostMapping("/panier")
    public Panier addPanier(@RequestParam String user_id){
        Users user = usersRepo.findById(user_id).orElse(null);
        if(user == null)
            return null;

        Panier panier = new Panier(user, null);

        panierRepo.save(panier);
        return panier;
    }

    @PostMapping("/commande")
    public Commande addCommande(@RequestParam int quantity,@RequestParam int panier_id,@RequestParam int product_id,@RequestParam String username){
        Users user = usersRepo.findById(username).orElse(null);
        Panier panier = panierRepo.findById(panier_id).orElse(null);
        Product product = productRepo.findById(product_id).orElse(null);

        if (user == null || panier == null || product == null)
            return null;

        Commande commande = new Commande(quantity, panier, user, product);

        commandeRepo.save(commande);
        return commande;
    }

}















