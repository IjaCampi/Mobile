/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.ijacampi.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Omar Amri
 */
public class HomeForm extends Form{
    
    Form current;

    public HomeForm() {
        
        current=this;
        
        
        setTitle("IjaCampi");
        setLayout(BoxLayout.y());

        
        Button btnAddTask = new Button("Ajouter Moyen Transport");
        Button btnListTasks = new Button("List");
        
        btnAddTask.addActionListener(e-> new ajouterTransportForm(current).show());
        btnListTasks.addActionListener(e-> new afficherTransportForm(current).show());
        addAll(btnAddTask,btnListTasks);
        
    }
    
    
    
}
