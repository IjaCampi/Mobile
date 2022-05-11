/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijacampi.mobile.Services;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.ijacampi.mobile.Entities.Equipement;
import com.ijacampi.mobile.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author brahim
 */
public class ServiceEquipement {
     public ArrayList<Equipement> tasks;
    
    public static ServiceEquipement instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceEquipement() {
         req = new ConnectionRequest();
    }

    public static ServiceEquipement getInstance() {
        if (instance == null) {
            instance = new ServiceEquipement();
        }
        return instance;
    }
    
    public boolean addEquipement(Equipement h) {
        String url = Statics.BASE_URL + "/equipement/json/new?nom=" + h.getNom() + "&photo=" + h.getPhoto()+
                "&description=" + h.getDescription() + "&marque=" + h.getMarque()+ "&prix=" + h.getPrix()+ "&categorie=" + h.getCategorie();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion        
        //req.setPost(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
   /* 
    public ArrayList<Equipement> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des hotels et récupération de leurs données
                Equipement h = new Equipement();
                float id = Float.parseFloat(obj.get("id").toString());
                //int id = Integer.parseInt(obj.get("id").toString());
                
                h.setId((int)id);
                h.setNom(obj.get("Nom").toString());
                h.setAdresse(obj.get("adresse").toString());
                h.setDescription(obj.get("description").toString());
                h.setImage(obj.get("image").toString());
                h.setPrix(Float.parseFloat(obj.get("prix").toString()));
                h.setNb_chambre((int)Float.parseFloat(obj.get("NbChambre").toString()));
                h.setNb_rate((int)Float.parseFloat(obj.get("nb_rate").toString()));
                h.setNb_etoile(Float.parseFloat(obj.get("NbEtoile").toString()));
                //Ajouter la tâche extraite de la réponse Json à la liste
                tasks.add(h);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        
        return tasks;
    }
    
    
    public ArrayList<Equipement> getAllEquipements(String nom){
        String url = Statics.BASE_URL+"/hebergementJSON/gethotels?nom="+nom;
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
    
    public boolean delete(int id)
    {
        String url=Statics.BASE_URL + "/hebergementJSON/deletehotel/"+id;
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
    public Equipement Detail(int id)
    {
        
        String url=Statics.BASE_URL+"/hebergementJSON/gethotel/"+id;
        req.setUrl(url);
         String sr=new String(req.getResponseData());
         Equipement h = new Equipement();
        
        req.addResponseListener((evt)->{
            
            JSONParser jSONParser=new JSONParser();  
            try {
          Map<String,Object>obj= jSONParser.parseJSON(new CharArrayReader(new String(sr).toCharArray()));

             
                h.setId(id);
                h.setNom(obj.get("Nom").toString());
                h.setAdresse(obj.get("adresse").toString());
                h.setDescription(obj.get("description").toString());
//                h.setImage(obj.get("image").toString());
                h.setPrix(Float.parseFloat(obj.get("prix").toString()));
                h.setNb_chambre((int)Float.parseFloat(obj.get("NbChambre").toString()));
//                h.setNb_rate(Integer.parseInt(obj.get("NbRate").toString()));
                h.setNb_etoile(Float.parseFloat(obj.get("NbEtoile").toString()));
                
            } catch (IOException e) {
                System.out.println("error related to sql"+e.getMessage());
            }
            System.out.println("date "+sr);
        });
                  NetworkManager.getInstance().addToQueueAndWait(req); 
                  return h;
    }
    
    public boolean modifier(Equipement h){
String url = Statics.BASE_URL+"/hebergementJSON/updatehotel/" + h.getId() + "?nom=" + h.getNom() + "&adresse=" + h.getAdresse()+ "&description=" + h.getDescription() + "&nbChambre=" + h.getNb_chambre() + "&prix=" + h.getPrix() + "&image=" + h.getImage()+ "&nbEtoile=" + h.getNb_etoile()+ "&nb_rate=" + h.getNb_rate();
req.setUrl(url);
req.addResponseListener(new ActionListener<NetworkEvent>() {
public void actionPerformed (NetworkEvent evt) {
resultOK = req.getResponseCode() == 200 ; // Code response Http 200 ok
req.removeResponseListener(this);
}});
NetworkManager.getInstance().addToQueueAndWait(req);//execution tal request sinon yet Sada chy dima nalawa
return resultOK;
    }
    
    public ArrayList<Equipement> getTriEquipements(double max,double min,String type){
        String url = Statics.BASE_URL+"/hebergementJSON/gettrihotels?max=" + max +"&min=" + min + "&type=" + type;
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
    }*/
}
