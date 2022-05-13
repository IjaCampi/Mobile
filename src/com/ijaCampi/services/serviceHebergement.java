/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijaCampi.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.ijaCampi.entites.Hebergement;
import com.ijaCampi.utils.statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




/**
 *
 * @author USER
 */
public class serviceHebergement {
    public ArrayList<Hebergement> hebergements;
    public static serviceHebergement instance;
    private ConnectionRequest req;
     public boolean resultOK;
    public serviceHebergement() {
            req=new ConnectionRequest();
           
            
    }
    
   public static serviceHebergement getInstance(){
        if (instance == null)
            instance = new serviceHebergement();
        return instance; 
   }
    
    public boolean ajouterHebergement(Hebergement h){
        String url =statics.BASE_URL+"/add";
         req.setUrl(url);
         req.setHttpMethod("POST");
        req.addResponseListener(new ActionListener <NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            resultOK = req.getResponseCode()==200;
            req.removeResponseListener(this);
            
        }
         
    });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
         return resultOK;  
    }
    public ArrayList<Hebergement> parseHebergement(String jsonText){
        try {
            hebergements= new ArrayList<Hebergement>();
            JSONParser j = new JSONParser();
            Map<String,Object> hebergementsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            java.util.List<Map<String,Object>> list = (java.util.List<Map<String,Object>>)hebergementsListJson.get("root");
            for (Map<String,Object> obj:list){
                 Hebergement h =new Hebergement();
                 String name = (String)obj.get("name");
                 String ville = (String)obj.get("ville");
                 String categorie = (String)obj.get("categorie");
                 h.setName(name);
                 h.setVille(ville);
                 h.setCategorie(categorie);
                 hebergements.add(h);
                 
            }
            
        } catch (IOException ex) {
            
        }
        return hebergements;
    }
    public ArrayList<Hebergement> getAllHebergements(){
        hebergements = new ArrayList<>();
        //Jsonb jsonb = JsonbBuilder.create();
        String url = statics.BASE_URL+"/json/allstages";
        req.setUrl(url);
        //req.setPost(false);
        req.setHttpMethod("GET");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
           // hebergements= parseHebergement(new String(req.getResponseData()));
          if (req.getResponseCode() == 200) {
                    hebergements = getList();
                }
            req.removeResponseListener(this);
           
            
        }});
        try {
            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hebergements;
    }
    private ArrayList<Hebergement> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(req.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                 Hebergement h =new Hebergement();
                 String name = (String)obj.get("name");
                 String ville = (String)obj.get("ville");
                 String categorie = (String)obj.get("categorie");
                 h.setName(name);
                 h.setVille(ville);
                 h.setCategorie(categorie);
                 hebergements.add(h);

                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hebergements;
    }
    public int delete(int evenementId) {
        req = new ConnectionRequest();
        req.setUrl(statics.BASE_URL + "/json/allstages");
        req.setHttpMethod("POST");
        req.addArgument("id", String.valueOf(evenementId));

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseListener(this);
            }
        });

        try {
            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return req.getResponseCode();
    }
    } 

