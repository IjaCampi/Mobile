/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.ijacampi.entities;

/**
 *
 * @author Omar Amri
 */
public class Utilisateur {
    
    private int id_user, num_tel;
    String nom,prenom,adresse,login,mdp,role,date_naissance;

    public Utilisateur(int id_user, int num_tel, String nom, String prenom, String adresse, String login, String mdp, String role, String date_naissance) {
        this.id_user = id_user;
        this.num_tel = num_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.login = login;
        this.mdp = mdp;
        this.role = role;
        this.date_naissance = date_naissance;
    }

    public Utilisateur(int num_tel, String nom, String prenom, String adresse, String login, String mdp, String role, String date_naissance) {
        this.num_tel = num_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.login = login;
        this.mdp = mdp;
        this.role = role;
        this.date_naissance = date_naissance;
    }

    public int getId_user() {
        return id_user;
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

    public String getAdresse() {
        return adresse;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public String getRole() {
        return role;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_user=" + id_user + ", num_tel=" + num_tel + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", login=" + login + ", mdp=" + mdp + ", role=" + role + ", date_naissance=" + date_naissance + '}';
    }
    
    
    
}
