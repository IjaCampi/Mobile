package com.ijaCampi.gui;

import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.ijaCampi.services.serviceReservationSimple;
import com.codename1.ui.layouts.BoxLayout;
import com.ijaCampi.entites.ReservationSimple;
import com.ijaCampi.services.serviceHebergement;


import java.util.ArrayList;

public class AjouterReservationForm extends Form {

    public AjouterReservationForm() {
    }
    
     public AjouterReservationForm(Form previous) {
        setTitle("Les Hebergements");
        
        SpanLabel sp = new SpanLabel();
       sp.setText(serviceReservationSimple.getInstance().getAll().toString());

        
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        
    }
}
