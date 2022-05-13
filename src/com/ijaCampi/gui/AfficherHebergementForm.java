/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijaCampi.gui;


import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.ijaCampi.entites.Hebergement;
import com.ijaCampi.services.serviceHebergement;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author USER
 */
public class AfficherHebergementForm extends Form{
    ArrayList<Component> componentModels;
    public AfficherHebergementForm() {
    }
    
     public AfficherHebergementForm(Form previous) {
        setTitle("Les Hebergements");
        
        SpanLabel sp = new SpanLabel();
        ArrayList<Hebergement> listEvenements = serviceHebergement.getInstance().getAllHebergements();
        componentModels = new ArrayList<>();
       sp.setText(serviceHebergement.getInstance().getAllHebergements().toString());
       
        
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        
    }
}
