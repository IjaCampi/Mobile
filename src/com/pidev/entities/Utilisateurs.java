package com.pidev.entities;

import com.codename1.ui.TextField;
import java.util.Date;

public class Utilisateurs {

    private int id_utilisateur,num_tel;
    private String nom;
    private String prenom;
    private String login;
    private String addresse;
    private String role;
    private String password;
    private String date_naissance;

    public Utilisateurs() {
    }

    public Utilisateurs(int id_utilisateur, int num_tel, String nom, String prenom, String login, String addresse, String role, String password, String date_naissance) {
        this.id_utilisateur = id_utilisateur;
        this.num_tel = num_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.addresse = addresse;
        this.role = role;
        this.password = password;
        this.date_naissance = date_naissance;
    }

    public Utilisateurs(int num_tel, String nom, String prenom, String login, String addresse, String role, String password, String date_naissance) {
        this.num_tel = num_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.addresse = addresse;
        this.role = role;
        this.password = password;
        this.date_naissance = date_naissance;
    }

    public Utilisateurs(TextField num_tf, TextField firstNameTF, TextField lastNameTF, TextField loginTF, TextField adresse_tf, TextField roeltf, TextField passTF, TextField date_tf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getAddresse() {
        return addresse;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate_naissance(String date_aissance) {
        this.date_naissance = date_aissance;
    }

    @Override
    public String toString() {
        return "Utilisateurs{" + "num_tel=" + num_tel + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", addresse=" + addresse + ", role=" + role + ", password=" + password + ", date_aissance=" + date_naissance + '}';
    }

    

}