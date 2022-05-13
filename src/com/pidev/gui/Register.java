package com.pidev.gui;


import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.pidev.entities.Utilisateurs;
import com.pidev.services.UserService;

public class Register extends Form {


    Label lbnom, lbprenom, lbadresse, lblog, lbpass, lprole,lbnum_tel,lbdate;
    TextField
            firstNameTF,
            lastNameTF,
            loginTF,
            passTF,
            roeltf,
            date_tf,
            num_tf,
            adresse_tf;
    


    Button manageButton;

    Form previous;

    public Register(Form previous) {
        super("Inscription", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;


        addGUIs();
        addActions();

        getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }


    private void addGUIs() {


        Label loginLabel = new Label("Vous avez deja un compte ?");

        Button loginBtn = new Button("Login");
        loginBtn.setUIID("buttonWhiteCenter");
        loginBtn.addActionListener(l -> new com.pidev.gui.Login().show());


        lbnom = new Label("FirstName : ");
        lbprenom.setUIID("labelDefault");
        firstNameTF = new TextField();
        firstNameTF.setHint("Tapez le firstName");

        lbprenom = new Label("LastName : ");
        lbprenom.setUIID("labelDefault");
        lastNameTF = new TextField();
        lastNameTF.setHint("Tapez le lastName");

        lblog = new Label("Email : ");
        lblog.setUIID("labelDefault");
        loginTF = new TextField();
        loginTF.setHint("Tapez le email");

        lbadresse = new Label("Username : ");
        lbadresse.setUIID("labelDefault");
                    adresse_tf = new TextField();
        adresse_tf.setHint("Tapez le username");

        lbpass = new Label("Password : ");
        lbpass.setUIID("labelDefault");
        passTF = new TextField();
        passTF.setHint("Tapez le password");
 lprole = new Label("Password : ");
        lprole.setUIID("labelDefault");
        roeltf = new TextField();
        roeltf.setHint("Tapez le password");

        lbnum_tel = new Label("Password : ");
        lbnum_tel.setUIID("labelDefault");
        num_tf = new TextField();
        num_tf.setHint("Tapez le password");

        lbdate = new Label("Password : ");
        lbdate.setUIID("labelDefault");
        date_tf = new TextField();
        date_tf.setHint("Tapez le password");
        
        manageButton = new Button("S'inscrire");
        manageButton.setUIID("buttonWhiteCenter");

        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        container.setUIID("containerRounded");

        container.addAll(

                lbnom, firstNameTF,
                lbprenom, lastNameTF,
                lbpass, passTF,
                lblog, loginTF,
                lbadresse, adresse_tf,
              lbdate,date_tf,
lprole,  roeltf,
              lbnum_tel,num_tf,
                manageButton,
                loginLabel, loginBtn
        );

        this.addAll(container);
    }

    private void addActions() {

        manageButton.addActionListener(action -> {
            if (controleDeSaisie()) {
                int responseCode = UserService.getInstance().add(
                        new Utilisateurs(


                           num_tf, firstNameTF, lastNameTF,loginTF,adresse_tf,roeltf,passTF,date_tf
               
              
                        )
                );
                if (responseCode == 200) {
                    Dialog.show("Succés", "Inscription effectué avec succes", new Command("Ok"));
                    previous.showBack();
                } else if (responseCode == 203) {
                    Dialog.show("Erreur", "Email deja utilisé", new Command("Ok"));
                } else {
                    Dialog.show("Erreur", "Erreur d'ajout de user. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            }
        });
    }

    private boolean controleDeSaisie() {


        if (firstNameTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir firstName", new Command("Ok"));
            return false;
        }


        if (lastNameTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir lastName", new Command("Ok"));
            return false;
        }


        if (num_tf.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir email", new Command("Ok"));
            return false;
        }


        if (loginTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir username", new Command("Ok"));
            return false;                                  
        }




        if (adresse_tf.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir password", new Command("Ok"));
            return false;
        }


        if (roeltf.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir password", new Command("Ok"));
            return false;
        }

        if (passTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir password", new Command("Ok"));
            return false;
        }

       if (date_tf.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir password", new Command("Ok"));
            return false;
        } 


        return true;
    }
}