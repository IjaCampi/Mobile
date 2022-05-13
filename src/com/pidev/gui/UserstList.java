/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.gui;

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
import com.pidev.entities.Utilisateurs;
import com.pidev.services.UserService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public class UserstList extends Form {
                 private Resources theme;
    private EncodedImage placeHolder;
    public UserstList(Form previous) {
        setTitle("List");
        
       
       // sp.setText(new ServiceEvent().getAllEvent().toString());
        ArrayList<Utilisateurs> reclamations = new UserService().getAllUsers();
        
        for (Utilisateurs obj : reclamations){
       
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
            btnnom.setText(String.valueOf(obj.getId_utilisateur()));
            SpanLabel sp = new SpanLabel();
            SpanLabel splieu1 = new SpanLabel();
            SpanLabel splieu2 = new SpanLabel();
            SpanLabel splieu3 = new SpanLabel();
            SpanLabel splieu4 = new SpanLabel();
            SpanLabel splieu5 = new SpanLabel();
            splieu1.setText(obj.getNom());
            splieu2.setText(obj.getPrenom());
            splieu3.setText(obj.getAddresse());
            
            Button delete = new Button("Delete");
             Button update = new Button("Update");
             
             
             delete.addActionListener((evt) -> {
                 new UserService().delete(obj.getId_utilisateur());
                 new  UserstList(previous).show();
             });
            
            
            addAll(btnnom,delete,update,sp,splieu1,splieu2,splieu3);
        }
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
        
        
    }
    
   
    
}
