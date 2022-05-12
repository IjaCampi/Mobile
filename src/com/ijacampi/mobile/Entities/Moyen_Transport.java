/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijacampi.mobile.Entities;

/**
 *
 * @author Omar Amri
 */
public class Moyen_Transport {
    
    private int id_transport;
    int id_user;
    String type, matricule, marque;
    int nbr_place ;
    double frais;

    public Moyen_Transport() {
    }

    public Moyen_Transport(int id_transport, int id_user, String type, String matricule, String marque, int nbr_place, double frais) {
        this.id_transport = id_transport;
        this.id_user = id_user;
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
        this.nbr_place = nbr_place;
        this.frais = frais;
    }

    public Moyen_Transport(String type, String matricule, String marque, int nbr_place, double frais) {
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
        this.nbr_place = nbr_place;
        this.frais = frais;
    }

    public int getId_transport() {
        return id_transport;
    }

    public int getId_user() {
        return id_user;
    }

    public String getType() {
        return type;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public double getFrais() {
        return frais;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    @Override
    public String toString() {
        return "Moyen_Transport{" + "id_transport=" + id_transport + ", id_user=" + id_user + ", type=" + type + ", matricule=" + matricule + ", marque=" + marque + ", nbr_place=" + nbr_place + ", frais=" + frais + '}';
    }
    
    
    
    
}
