
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
    
    
    
    public ArrayList<Moyen_Transport> Transport;
    
    public static ServiceMoyenTransport instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceMoyenTransport() {
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

    
}
