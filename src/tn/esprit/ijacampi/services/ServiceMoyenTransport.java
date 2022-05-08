
package tn.esprit.ijacampi.services;

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
import tn.esprit.ijacampi.entities.Moyen_Transport;

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
        System.out.println(moy);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "create";

       
       req.setUrl(url);
       req.setPost(false);
       
       req.addArgument("Type", moy.getType());
       req.addArgument("Matricule", moy.getMatricule()+"");
       req.addArgument("Marque", moy.getMarque()+"");
       req.addArgument("Nombre de Places", moy.getNbr_place()+"");
       
       
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public ArrayList<Moyen_Transport> parseTasks(String jsonText){
        try {
            Transport=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Moyen_Transport moy = new Moyen_Transport();
                float id = Float.parseFloat(obj.get("id_transport").toString());
                moy.setId_transport((int)id);
                moy.setType(((int)Float.parseFloat(obj.get("type").toString())));
                moy.setType(((int)Float.parseFloat(obj.get("matricule").toString())));
                moy.setType(((int)Float.parseFloat(obj.get("marque").toString())));
                moy.setType(((int)Float.parseFloat(obj.get("nbr_place").toString())));
                
            }
            
            
        } catch (IOException ex) {
            
        }
        return Transport;
    }
    
    
    public ArrayList<Moyen_Transport> afficherTransport(){
        req = new ConnectionRequest();
        String url = Statics.BASE_URL+"get/";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Transport = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Transport;
    }
    
    
}
