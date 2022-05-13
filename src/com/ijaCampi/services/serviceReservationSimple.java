
 

 
package com.ijaCampi.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import com.ijaCampi.entites.Hebergement;
import com.ijaCampi.entites.ReservationSimple;
import com.ijaCampi.utils.statics;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class serviceReservationSimple {

    public static serviceReservationSimple instance = null;
    public int resultCode;
    private ConnectionRequest cr;
    private ArrayList<ReservationSimple> listEvenements;


    private serviceReservationSimple() {
        cr = new ConnectionRequest();
    }

    public static serviceReservationSimple getInstance() {
        if (instance == null) {
            instance = new serviceReservationSimple();
        }
        return instance;
    }

    public ArrayList<ReservationSimple> getAll() {
        listEvenements = new ArrayList<>();

        cr = new ConnectionRequest();
        cr.setUrl(statics.BASE_URL + "/evenement");
        cr.setHttpMethod("GET");

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                if (cr.getResponseCode() == 200) {
                    listEvenements = getList();
                }

                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listEvenements;
    }

    private ArrayList<ReservationSimple> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(cr.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                ReservationSimple evenement = new ReservationSimple(
                       
                        
                        (String) obj.get("nameHebergement"),
                        (Date) obj.get("dateDebut"),
                        (Date) obj.get("dateFin"),
                       
                        (int) obj.get("User_id")
                        
                        

                );

                listEvenements.add(evenement);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listEvenements;
    }

    public Hebergement makeHebergement(Map<String, Object> obj) {
        if (obj == null) {
            return null;
        }
        Hebergement hebergement = new Hebergement();
        hebergement.setId((int) Float.parseFloat(obj.get("id").toString()));
        hebergement.setName((String) obj.get("name"));
        return hebergement;
    }

    

    public int add(ReservationSimple evenement) {
        return manage(evenement, false);
    }

    public int edit(ReservationSimple evenement) {
        return manage(evenement, true);
    }

    public int manage(ReservationSimple evenement, boolean isEdit) {

        cr = new ConnectionRequest();


        cr.setHttpMethod("POST");
        if (isEdit) {
            cr.setUrl(statics.BASE_URL + "/evenement/edit");
            cr.addArgument("id", String.valueOf(evenement.getId_rs()));
        } else {
            cr.setUrl(statics.BASE_URL + "/evenement/add");
        }

       
//        cr.addArgument("nomEvent", evenement.getNameHebergement());
//        cr.addArgument("description",evenement.getUser_id());
//        cr.addArgument("dateDebut", evenement.getDateDebut());
//        cr.addArgument("dateFin", evenement.getDateFin());
//        

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultCode = cr.getResponseCode();
                cr.removeResponseListener(this);
            }
        });
        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception ignored) {

        }
        return resultCode;
    }

    public int delete(int evenementId) {
        cr = new ConnectionRequest();
        cr.setUrl(statics.BASE_URL + "/evenement/delete");
        cr.setHttpMethod("POST");
        cr.addArgument("id", String.valueOf(evenementId));

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cr.getResponseCode();
    }
}
