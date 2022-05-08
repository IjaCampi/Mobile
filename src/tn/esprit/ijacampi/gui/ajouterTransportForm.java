/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.ijacampi.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import tn.esprit.ijacampi.entities.Moyen_Transport;
import tn.esprit.ijacampi.services.ServiceMoyenTransport;

/**
 *
 * @author Omar Amri
 */
public class ajouterTransportForm extends Form{

    public ajouterTransportForm(Form previous) {

        setTitle("Ajouter Moyen Transport");
        setLayout(BoxLayout.y());
        
        TextField tfType = new TextField("","type");
        TextField tfMatricule= new TextField("", "matricule");
        TextField tfMarque= new TextField("", "marque");
        TextField tfNbrPlace= new TextField("", "nbr_place");
        TextField tfFrais= new TextField("", "frais");
        
        Button btnValider = new Button("Ajouter");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public String actionPerformed(ActionEvent evt) {
                if 
                    ((tfType.getText().length()==0)||(tfMarque.getText().length()==0)
                        ||(tfNbrPlace.getText().length()==0)
                        ||(tfFrais.getText().length()==0)
                        ||(tfMatricule.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                
                else
                {
                    try {
                        Moyen_Transport moy = new Moyen_Transport(tfType.getText().toString(), tfMatricule.getText().toString()
                                , tfMarque.getText().toString(), Integer.parseInt(tfNbrPlace.getText())
                                , Float.parseFloat(tfFrais.getText()));
                        if( ServiceMoyenTransport.getInstance().ajouterTransport(moy))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                       }else
                            //Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                           System.out.println(e.getMessage());
                            }
                            Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfType,tfMatricule,tfMarque,tfNbrPlace,tfFrais,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
        
    }
    
    
}
