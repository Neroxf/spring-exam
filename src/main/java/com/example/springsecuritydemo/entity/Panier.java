package com.example.springsecuritydemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "userId")
    private Users user;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "panier")
    private List<Commande> commande;


    public Panier(int id, Users user, List<Commande> commande) {
        this.id = id;
        this.user = user;
        this.commande = commande;
    }

    public Panier(Users user, List<Commande> commande) {
        this.user = user;
        this.commande = commande;
    }

    public Panier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }
}
