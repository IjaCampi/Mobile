/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijaCampi.entites;

/**
 *
 * @author USER
 */
public class Hebergement {
    private int id; 
    public String name;
    public String ville;
    public String categorie;
    public int capacite;
    public Boolean disponibilite; 
    public int prix;
    private int id_user; 

    public Hebergement(int id, String name, String ville, String categorie, int capacite, Boolean disponibilite, int prix, int id_user) {
        this.id = id;
        this.name = name;
        this.ville = ville;
        this.categorie = categorie;
        this.capacite = capacite;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.id_user = id_user;
    }

    public Hebergement(String name, String ville, String categorie, int capacite, Boolean disponibilite, int prix, int id_user) {
        this.name = name;
        this.ville = ville;
        this.categorie = categorie;
        this.capacite = capacite;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.id_user = id_user;
    }

    public Hebergement(String name, String ville, String categorie, int capacite, Boolean disponibilite, int prix) {
        this.name = name;
        this.ville = ville;
        this.categorie = categorie;
        this.capacite = capacite;
        this.disponibilite = disponibilite;
        this.prix = prix;
    }

    public Hebergement() {
       //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVille() {
        return ville;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getCapacite() {
        return capacite;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public int getPrix() {
        return prix;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Hebergement{" + "id=" + id + ", name=" + name + ", ville=" + ville + ", categorie=" + categorie + ", capacite=" + capacite + ", disponibilite=" + disponibilite + ", prix=" + prix + ", id_user=" + id_user + '}';
    }
    
}
