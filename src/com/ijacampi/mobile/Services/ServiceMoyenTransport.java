
package com.ijacampi.mobile.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.ijacampi.mobile.Entities.Moyen_Transport;
import com.ijacampi.mobile.utils.Statics;

/**
 *
 * @author Omar Amri
 */
public class ServiceMoyenTransport {
    
    

    public ArrayList<Moyen_Transport> tasks;
    public ArrayList<Moyen_Transport> reclamations;
    
    public static ServiceMoyenTransport instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceMoyenTransport() {
         req = new ConnectionRequest();
    }

    public static ServiceMoyenTransport getInstance() {
        if (instance == null) {
            instance = new ServiceMoyenTransport();
        }
        return instance;
    }
    
    
    public boolean ajouterTransport(Moyen_Transport moy) {
        
        String url = Statics.BASE_URL +
                "/moyen/transport/newJson?type=" + moy.getType()+
                "&matricule=" + moy.getMatricule()+
                "&marque=" + moy.getMarque()+
                "&nbr_place=" + moy.getNbr_place()+
                "&frais=" + moy.getFrais();
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
    
    public ArrayList<Moyen_Transport> parseTasks(String jsonText){
            
         try {
               reclamations = new ArrayList<>();
               
               JSONParser j = new JSONParser();
               Map<String,Object> eventListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
               List<Map<String, Object>> list = (List<Map<String,Object>>)eventListJson.get("root");
               System.out.println(eventListJson.toString());
               
               
               for (Map<String, Object> obj : list) {
                   Moyen_Transport moy = new Moyen_Transport();
                   float id = Float.parseFloat(obj.get("idTransport").toString());
                    moy.setId_transport((int)id);
                    
                   moy.setType(obj.get("type").toString());
                   moy.setMatricule(obj.get("matricule").toString());
                   moy.setMarque(obj.get("marque").toString());
                   //Integer nbr_place = Integer.parseInt(obj.get("nbrPlace").toString());
                   //moy.setNbr_place((int)nbr_place);
                   double frais = Double.parseDouble(obj.get("frais").toString());
                    moy.setFrais((double)frais);
                    
                   System.out.println(moy.toString());
                   reclamations.add(moy);
                   
               }
             
               
           } catch (IOException ex) {
             //  Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
           }
           return reclamations;
            }
    
    
    
    public ArrayList<Moyen_Transport> getAllTransport (){
        String url = Statics.BASE_URL+"/moyen/transport/index/json/";
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
    
    public boolean delete(int idTransport)
    {
        String url=Statics.BASE_URL + "/moyen/transport/json/delete/"+idTransport;
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
    
    
    public boolean update(Moyen_Transport moy){
        String url = Statics.BASE_URL+"/hebergementJSON/updatehotel/" + moy.getId_transport()+
                "?type=" + moy.getType()+
                "&matricule=" + moy.getMatricule()+
                "&marque=" + moy.getMarque()+
                "&nbr_place=" + moy.getNbr_place()+
                "&frais=" + moy.getFrais();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
        public void actionPerformed (NetworkEvent evt) {
        resultOK = req.getResponseCode() == 200 ; // Code response Http 200 ok
        req.removeResponseListener(this);
        }});
        NetworkManager.getInstance().addToQueueAndWait(req);//execution tal request sinon yet Sada chy dima nalawa
        return resultOK;
    }
    

    
}
