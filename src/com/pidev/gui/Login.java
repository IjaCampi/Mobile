package com.pidev.gui;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.pidev.MainApp;
import com.pidev.entities.Utilisateurs;
import com.pidev.services.UserService;

public class Login extends Form {

    public static Form loginForm;

    public Login() {
        super("Connexion", new BoxLayout(BoxLayout.Y_AXIS));
        loginForm = this;
        addGUIs();
    }

    private void addGUIs() {


        TextField tflog = new TextField("");
        tflog.setHint("Tapez votre login");

        TextField tfpass = new TextField("", "Tapez votre mot de passe", 20, TextField.PASSWORD);

        Button connectBtn = new Button("Connexion");
        connectBtn.setUIID("buttonWhiteCenter");
        connectBtn.addActionListener(l -> connexion(tflog.getText(), tfpass.getText()));

        Label registerLabel = new Label("Besoin d'un compte ?");

        Button registerBtn = new Button("Register");
        registerBtn.setUIID("buttonWhiteCenter");
        registerBtn.addActionListener(l -> new com.pidev.gui.back.AccueilBack().show());

        this.addAll(tflog, tfpass, connectBtn, registerLabel, registerBtn);


        Button backendBtn = new Button("Back");
        backendBtn.addActionListener(l -> new com.pidev.gui.back.AccueilBack().show());

        this.add(backendBtn);
    }

    private void connexion(String login, String password) {
        Utilisateurs user = UserService.getInstance().checkCredentials(login, password);

        if (user != null) {
            MainApp.setSession(user);
            new com.pidev.gui.back.ShowAll(loginForm);
        } else {
            Dialog.show("Erreur", "Identifiants invalides", new Command("Ok"));
        }
    }
}
