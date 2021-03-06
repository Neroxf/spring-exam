package com.example.springsecuritydemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "locked")
    private boolean locked;

    @Basic
    private String email;


    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "username")
    private List<Authorities> authorities;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Commande> commandes;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "user")
    private List<Panier> paniers;


    public Users(String username, String password, boolean enabled, boolean locked, String email, List<Authorities> authorities, List<Commande> commandes, List<Panier> paniers) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.locked = locked;
        this.email = email;
        this.authorities = authorities;
        this.commandes = commandes;
        this.paniers = paniers;
    }

    public Users(String password, boolean enabled, boolean locked, String email, List<Authorities> authorities, List<Commande> commandes, List<Panier> paniers) {
        this.password = password;
        this.enabled = enabled;
        this.locked = locked;
        this.email = email;
        this.authorities = authorities;
        this.commandes = commandes;
        this.paniers = paniers;
    }

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<Panier> paniers) {
        this.paniers = paniers;
    }
}
