package com.pidev.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import com.pidev.entities.Utilisateurs;
import com.pidev.utils.Statics;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserService {
    
        public ArrayList<Utilisateurs> tasks;
    public ArrayList<Utilisateurs> reclamations;
    public static UserService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public int resultCode;
    Utilisateurs user;
    private ArrayList<Utilisateurs> listUsers;

    public UserService() {
        req = new ConnectionRequest();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    
    
    
    
    public ArrayList<Utilisateurs> parseTasks(String jsonText){
            
         try {
               reclamations = new ArrayList<>();
               
               JSONParser j = new JSONParser();
               Map<String,Object> eventListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
               List<Map<String, Object>> list = (List<Map<String,Object>>)eventListJson.get("root");
               System.out.println(eventListJson.toString());
               
               
               for (Map<String, Object> obj : list) {
                   Utilisateurs user = new Utilisateurs();
                   float id = Float.parseFloat(obj.get("idUser").toString());
                    user.setId_utilisateur((int)id);
                    
                   user.setNom(obj.get("nom").toString());
                   user.setPrenom(obj.get("prenom").toString());
                   //user.setDate_naissance(obj.get("date_naissance").toString());
                   user.setAddresse(obj.get("adresse").toString());
                   //Integer nbr_place = Integer.parseInt(obj.get("nbrPlace").toString());
                   //moy.setNbr_place((int)nbr_place);
                   user.setLogin(obj.get("login").toString());
                   user.setPassword(obj.get("password").toString());
                    
                   System.out.println(user.toString());
                   reclamations.add(user);
                   
               }
             
               
           } catch (IOException ex) {
             //  Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
           }
           return reclamations;
            }
    
    
    
    public ArrayList<Utilisateurs> getAllUsers (){
        String url = Statics.BASE_URL+"/utilisateurs/index/json/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    
    public boolean delete(int idUser)
    {
        String url=Statics.BASE_URL + "/utilisateurs/json/delete/"+idUser;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseCodeListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
 
    }
    



   
}
