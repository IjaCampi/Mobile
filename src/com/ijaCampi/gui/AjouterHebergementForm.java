/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijaCampi.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.ijaCampi.entites.Hebergement;
import com.ijaCampi.services.serviceHebergement;

/**
 *
 * @author USER
 */
public class AjouterHebergementForm extends Form {

    public AjouterHebergementForm(Form previous) {
        setTitle("Ajouter Hebergement");
        setLayout(BoxLayout.y());
        TextField tfNom = new TextField("", "Nom");
        TextField tfVille = new TextField("", "ville");
        TextField tfCategorie =  new TextField("","Categorie");
        TextField tfCapacite =  new TextField("","Capacité");
        TextField tfPrix =  new TextField("","Prix");
        tfCapacite.addDataChangedListener((i, ii) -> {
    if(isValidInput(tfCapacite.getText())) {
       tfCapacite.putClientProperty("LastValid", tfCapacite.getText());
    } else {
       tfCapacite.stopEditing();
       tfCapacite.setText((String)tfCapacite.getClientProperty("LastValid"));
       tfCapacite.startEditingAsync();
    }
});
          tfPrix.addDataChangedListener((i, ii) -> {
    if(isValidInput(tfPrix.getText())) {
       tfPrix.putClientProperty("LastValid", tfPrix.getText());
    } else {
       tfPrix.stopEditing();
       tfPrix.setText((String)tfPrix.getClientProperty("LastValid"));
       tfPrix.startEditingAsync();
    }
});
        Button btnValider = new Button ("Ajouter Hebergement");
        btnValider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
            if ((tfNom.getText().length()==0))
            Dialog.show("Alert","please fill all the fields", new Command("OK"));
            else {
             
                String name = tfNom.getText();
                String ville = tfVille.getText();
                String categorie = tfCategorie.getText();
                int capacite = Integer.parseInt(tfCapacite.getText());
                int prix = Integer.parseInt(tfPrix.getText());
                Hebergement h = new Hebergement( name,  ville,  categorie,  capacite,  true ,prix, 1);
                if (new serviceHebergement().ajouterHebergement(h))
                    Dialog.show("Sucess","c'est fait", new Command("OK"));
                else 
                    Dialog.show("ERROR","Serveur", new Command("OK"));
         
        }
            }
        });
        addAll(tfNom,tfVille,tfCategorie,tfCapacite,tfPrix,btnValider);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        
    }
    public boolean isValidInput(String input){

    if(input.contains("a") || input.contains("b") || input.contains("c") 
    || input.contains("d") || input.contains("e") || input.contains("f")
    || input.contains("g") || input.contains("h") || input.contains("i")
    || input.contains("j") || input.contains("k") || input.contains("l")
    || input.contains("m") || input.contains("n") || input.contains("o")
    || input.contains("p") || input.contains("q") || input.contains("r")
    || input.contains("s") || input.contains("t") || input.contains("u")
    || input.contains("v") || input.contains("w") || input.contains("x")
    || input.contains("y") || input.contains("z")) {
        return false;
    }
    else {
        return true;
    }
}

}
