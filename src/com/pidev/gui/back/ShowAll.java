package com.pidev.gui.back;


import com.pidev.gui.*;
import com.codename1.components.InteractionDialog;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.pidev.entities.Utilisateurs;
import com.pidev.gui.Manage;
import com.pidev.services.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ShowAll extends Form {

    public static Utilisateurs currentUser = null;
    Form previous;
    Button addBtn;

    TextField searchTF;
    ArrayList<Component> componentModels;
    Label firstNameLabel, lastNameLabel, emailLabel, usernameLabel, rolesLabel, passwordLabel, createdAtLabel;
    Button editBtn, deleteBtn;
    Container btnsContainer;

    public ShowAll(Form previous) {
        super("Users", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;


        super.getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    public void refresh() {
        this.removeAll();
        this.refreshTheme();
    }

   

    private Container makeModelWithoutButtons(Utilisateurs user) {
        Container userModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        userModel.setUIID("containerRounded");


        firstNameLabel = new Label("FirstName : " + user.getNom());
        firstNameLabel.setUIID("labelDefault");

      
        userModel.addAll(

                firstNameLabel, lastNameLabel, emailLabel, usernameLabel, rolesLabel, passwordLabel, createdAtLabel
        );

        return userModel;
    }

  
}