/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijaCampi.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author USER
 */
public class HomeForm extends Form{
Form current;
    public HomeForm() {
        current = this;
        setTitle("Home Page");
        setLayout(BoxLayout.y());
        Button btnAjouterHebergement = new Button ("Ajouter Hebergement");
        Button btnAfficherHebergement = new Button ("Afficher Hebergement");
        Button btnAjouterReservation = new Button ("Ajouter Reservation");
        Button btnAfficherReservation = new Button ("Afficher Reservation");
        btnAjouterHebergement.addActionListener(e->new AjouterHebergementForm(current).show());
        btnAfficherHebergement.addActionListener(e->new AfficherHebergementForm(current).show());
        btnAjouterReservation.addActionListener(e->new AjouterReservationForm(current).show());
        btnAfficherReservation.addActionListener(e->new AfficherReservationForm(current).show());
        addAll(btnAjouterHebergement,btnAfficherHebergement,btnAjouterReservation,btnAfficherReservation);
    }
    
}
