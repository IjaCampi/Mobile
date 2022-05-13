package com.pidev.gui;



import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.pidev.entities.Utilisateurs;
import com.pidev.gui.back.ShowAll;
import com.pidev.services.UserService;
import com.pidev.utils.AlertUtils;

public class Manage extends Form {


    Utilisateurs currentUser;

    TextField firstNameTF;
    TextField lastNameTF;
    TextField emailTF;
    TextField usernameTF;
    TextField rolesTF;
    TextField passwordTF;
    Label firstNameLabel;
    Label lastNameLabel;
    Label emailLabel;
    Label usernameLabel;
    Label rolesLabel;
    Label passwordLabel;
    PickerComponent createdAtTF;


    Button manageButton;

    Form previous;

    public Manage(Form previous) {
        super(ShowAll.currentUser == null ? "Ajouter" : "Modifier", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        currentUser = ShowAll.currentUser;

        addGUIs();
        getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    private void addGUIs() {


        firstNameLabel = new Label("FirstName : ");
        firstNameLabel.setUIID("labelDefault");
        firstNameTF = new TextField();
        firstNameTF.setHint("Tapez le firstName");


        lastNameLabel = new Label("LastName : ");
        lastNameLabel.setUIID("labelDefault");
        lastNameTF = new TextField();
        lastNameTF.setHint("Tapez le lastName");


        emailLabel = new Label("Email : ");
        emailLabel.setUIID("labelDefault");
        emailTF = new TextField();
        emailTF.setHint("Tapez le email");


        usernameLabel = new Label("Username : ");
        usernameLabel.setUIID("labelDefault");
        usernameTF = new TextField();
        usernameTF.setHint("Tapez le username");


        rolesLabel = new Label("Roles : ");
        rolesLabel.setUIID("labelDefault");
        rolesTF = new TextField();
        rolesTF.setHint("Tapez le roles");


        passwordLabel = new Label("Password : ");
        passwordLabel.setUIID("labelDefault");
        passwordTF = new TextField();
        passwordTF.setHint("Tapez le password");


        createdAtTF = PickerComponent.createDate(null).label("CreatedAt");


        if (currentUser == null) {


            manageButton = new Button("Ajouter");
        } else {
            firstNameTF.setText(currentUser.getAddresse());
            lastNameTF.setText(currentUser.getDate_naissance());
           

            manageButton = new Button("Modifier");
        }
        manageButton.setUIID("buttonWhiteCenter");

        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        container.setUIID("containerRounded");

        container.addAll(

                firstNameLabel, firstNameTF,
                lastNameLabel, lastNameTF,
                emailLabel, emailTF,
                usernameLabel, usernameTF,
                rolesLabel, rolesTF,
                passwordLabel, passwordTF,
                createdAtTF,

                manageButton
        );

        this.addAll(container);
    }

   
      
                   

    private void showBackAndRefresh() {
        ((ShowAll) previous).refresh();
        previous.showBack();
    }

    private boolean controleDeSaisie() {


        if (firstNameTF.getText().equals("")) {
            Dialog.show("Avertissement", "FirstName vide", new Command("Ok"));
            return false;
        }


        if (lastNameTF.getText().equals("")) {
            Dialog.show("Avertissement", "LastName vide", new Command("Ok"));
            return false;
        }


        if (emailTF.getText().equals("")) {
            Dialog.show("Avertissement", "Email vide", new Command("Ok"));
            return false;
        }


        if (usernameTF.getText().equals("")) {
            Dialog.show("Avertissement", "Username vide", new Command("Ok"));
            return false;
        }


        if (rolesTF.getText().equals("")) {
            Dialog.show("Avertissement", "Roles vide", new Command("Ok"));
            return false;
        }


        if (passwordTF.getText().equals("")) {
            Dialog.show("Avertissement", "Password vide", new Command("Ok"));
            return false;
        }


        if (createdAtTF.getPicker().getDate() == null) {
            Dialog.show("Avertissement", "Veuillez saisir la createdAt", new Command("Ok"));
            return false;
        }


        return true;
    }
}