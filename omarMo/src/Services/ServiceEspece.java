/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Espece;
import static Services.ServiceEspece.instance;
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
import utils.Statics;

/**
 *
 * @author TH3OMAR
 */
public class ServiceEspece {
  
    public ArrayList<Espece> especes;
    public String result = "";
    public static ServiceEspece instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceEspece() {
        req = new ConnectionRequest();
    }

    public static ServiceEspece getInstance() {
        if (instance == null) {
            instance = new ServiceEspece();
        }
        return instance;
    }
    
    
        //Affichage Espece
    public ArrayList<Espece> getAllEspeces(int id){
        String url = Statics.BASE_URL+"espece?id="+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                especes = parseEspece(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);     
                return especes;
    }
    
    
     
    public ArrayList<Espece> parseEspece(String jsonText){
        try {
            especes=new ArrayList<Espece>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Espece E = new Espece();
                E.setNom(obj.get("nom").toString());
                E.setType(obj.get("type").toString());
                E.setDescription(obj.get("description").toString());       
                E.setNomImage(obj.get("nomImage").toString());
       
                especes.add(E);
            }
            
            
        } catch (IOException ex) {
            
        }
       
        return especes;
    }
    
    
}
