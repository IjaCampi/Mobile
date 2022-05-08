/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.ijacampi.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import tn.esprit.ijacampi.services.ServiceMoyenTransport;

/**
 *
 * @author Omar Amri
 */
public class afficherTransportForm extends Form{


    afficherTransportForm(Form previous) {
        
        setTitle("List des Moyens Transport");

        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceMoyenTransport.getInstance().afficherTransport().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
    }
    
}
