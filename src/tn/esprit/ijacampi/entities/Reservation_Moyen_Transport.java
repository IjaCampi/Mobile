/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.ijacampi.entities;

import java.sql.Date;

/**
 *
 * @author Omar Amri
 */
public class Reservation_Moyen_Transport {
    
    private int id_reservation;
    int id_user;
    int id_transport;
    Date date_debut, date_fin;
    String place;

    public Reservation_Moyen_Transport() {
    }

    public Reservation_Moyen_Transport(int id_reservation, int id_user, int id_transport, Date date_debut, Date date_fin, String place) {
        this.id_reservation = id_reservation;
        this.id_user = id_user;
        this.id_transport = id_transport;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.place = place;
    }

    public Reservation_Moyen_Transport(Date date_debut, Date date_fin, String place) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.place = place;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_transport() {
        return id_transport;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getPlace() {
        return place;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Reservation_Moyen_Transport{" + "id_reservation=" + id_reservation + ", id_user=" + id_user + ", id_transport=" + id_transport + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", place=" + place + '}';
    }
    
    
    
    
}
