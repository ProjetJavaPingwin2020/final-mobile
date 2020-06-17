/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Categorie_espece;
import Entity.Espece;
import com.codename1.io.ConnectionRequest;
import java.util.ArrayList;
import static Services.ServiceCatEspece.instance;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author TH3OMAR
 */
public class ServiceCatEspece {
     
    public ArrayList<Categorie_espece> cat_especes;
    public String result = "";
    public static ServiceCatEspece instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCatEspece() {
        req = new ConnectionRequest();
    }

    public static ServiceCatEspece getInstance() {
        if (instance == null) {
            instance = new ServiceCatEspece();
        }
        return instance;
    } 
    
    
            //Affichage Espece
    public ArrayList<Categorie_espece> getAllCat(){
        String url = Statics.BASE_URL+"categorie/espece";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cat_especes = parseCat(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);     
                return cat_especes;
    }
    
    public boolean del(int id){
          String url = Statics.BASE_URL+"categorie/supp?id="+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                if (req.getResponseCode() == 200){ 
                  
                   resultOK = true;
                
                }else {
                    resultOK = false;
                }
                    
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);     
       return  resultOK;
      
    }
    
    
    
    
        public boolean Add (String Name){
          String url = Statics.BASE_URL+"categorie/new?name="+Name;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                if (req.getResponseCode() == 200){ 
                  
                   resultOK = true;
                
                }else {
                    resultOK = false;
                }
                    
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);     
       return  resultOK;
      
    }
    
    
    
    
    
    
    
    
    
    
       
    public ArrayList<Categorie_espece> parseCat(String jsonText){
        try {
            cat_especes =new ArrayList<Categorie_espece>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
               Categorie_espece E = new Categorie_espece();
       
              float id = Float.parseFloat(obj.get("id").toString());
               E.setNom(obj.get("nom").toString());
               E.setImage(obj.get("nomImage").toString());
        
            E.setId((int)id);
                cat_especes.add(E);
            }
            
            
        } catch (IOException ex) {
            
        }
       
        return cat_especes;
    }
    
    
    
    
}
