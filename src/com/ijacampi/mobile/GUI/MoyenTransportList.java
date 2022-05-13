/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijacampi.mobile.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.ijacampi.mobile.Entities.Equipement;
import com.ijacampi.mobile.Entities.Moyen_Transport;
import com.ijacampi.mobile.Services.ServiceEquipement;
import com.ijacampi.mobile.Services.ServiceMoyenTransport;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public class MoyenTransportList extends Form {
                 private Resources theme;
    private EncodedImage placeHolder;
    public MoyenTransportList(Form previous) {
        setTitle("List des Moyen Transport");
        
       
       // sp.setText(new ServiceEvent().getAllEvent().toString());
        ArrayList<Moyen_Transport> reclamations = new ServiceMoyenTransport().getAllTransport();
        
        for (Moyen_Transport obj : reclamations){
       
            setLayout(BoxLayout.y());
             Button btnnom = new Button();
             
          /*   
             update.addActionListener((evt) -> {
                 
                 UpdateRecForm.statut.setText(obj.getStatut());
                 UpdateRecForm.description.setText(obj.getDescription());
                 UpdateRecForm.id.setText(String.valueOf(obj.getId()));
                 new UpdateRecForm(previous).show();
                 
              
                 
                 
             });
*/
            btnnom.setText(String.valueOf(obj.getId_transport()));
            SpanLabel sp = new SpanLabel();
            SpanLabel splieu1 = new SpanLabel();
            SpanLabel splieu2 = new SpanLabel();
            SpanLabel splieu3 = new SpanLabel();
            SpanLabel splieu4 = new SpanLabel();
            SpanLabel splieu5 = new SpanLabel();
            splieu1.setText(obj.getType());
            splieu2.setText(obj.getMatricule());
            splieu3.setText(obj.getMarque());
            splieu4.setText(Double.toString(obj.getFrais()));
            splieu5.setText(Integer.toString(obj.getNbr_place()));
            
            Button delete = new Button("Delete");
             Button update = new Button("Update");
             
             
             delete.addActionListener((evt) -> {
                 new ServiceMoyenTransport().delete(obj.getId_transport());
                 new  MoyenTransportList(previous).show();
             });
            
            
            addAll(btnnom,delete,update,sp,splieu1,splieu2,splieu3,splieu4,splieu5);
        }
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
        
        
    }
    
   
    
}
