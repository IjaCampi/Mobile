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
import com.ijacampi.mobile.Services.ServiceEquipement;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public class EquipementList extends Form {
                 private Resources theme;
    private EncodedImage placeHolder;
    public EquipementList(Form previous) {
        setTitle("List Reclamations");
        
       
       // sp.setText(new ServiceEvent().getAllEvent().toString());
        ArrayList<Equipement> reclamations = new ServiceEquipement().getAllEquipements();
        
        for (Equipement obj : reclamations){
       
            setLayout(BoxLayout.y());
             Button btnnom = new Button();
             Button delete = new Button("Delete");
             Button update = new Button("Update");
             
             
             delete.addActionListener((evt) -> {
                 new ServiceEquipement().delete(obj.getId());
                 new  EquipementList(previous).show();
             });
          /*   
             update.addActionListener((evt) -> {
                 
                 UpdateRecForm.statut.setText(obj.getStatut());
                 UpdateRecForm.description.setText(obj.getDescription());
                 UpdateRecForm.id.setText(String.valueOf(obj.getId()));
                 new UpdateRecForm(previous).show();
                 
              
                 
                 
             });
*/
             btnnom.setText(String.valueOf(obj.getId()));
             SpanLabel sp = new SpanLabel();
             SpanLabel splieu = new SpanLabel();
            //sp.setText(obj.getStatut());
            splieu.setText(obj.getDescription());
            addAll(btnnom,delete,update,sp,splieu);
        }
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
        
        
    }
    
   
    
}
