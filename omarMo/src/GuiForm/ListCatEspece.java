/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiForm;

import Entity.Categorie_espece;
import Services.ServiceCatEspece;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author TH3OMAR
 */
public class ListCatEspece extends BaseForm{ 
    
    static Form currentForm;
    public static Form f, form;

    private EncodedImage placeHolder;
    
    public ListCatEspece(Resources res){
        
         super("Newsfeed", BoxLayout.y());

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Liste des Categories");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
       // tb.addSearchCommand(e -> {
     //   });

        Image imge = res.getImage("profile-background.jpg");
        if (imge.getHeight() > Display.getInstance().getDisplayHeight() / 5) {
            imge = imge.scaledHeight(Display.getInstance().getDisplayHeight() / 5);
        }
        ScaleImageLabel sl = new ScaleImageLabel(imge);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

       add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3,FlowLayout.encloseCenter(new Label(res.getImage(""), "PictureWhiteBackgrond"))     )
                )
        ));
        currentForm = this;
       // currentForm.setTitle("Formation");
       // currentForm.setLayout(BoxLayout.y());
       
       
        for (Categorie_espece E : ServiceCatEspece.getInstance().getAllCat()) {
            Container InfoContainer = new Container(BoxLayout.y());

            Label nom = new Label("Nom  : " + E.getNom());
            nom.getAllStyles().setFgColor(0x000000);
            Button listespece  = new Button("Consulter");
           
            InfoContainer.add(nom);
            InfoContainer.add(listespece);
            
            
           
              
            listespece.addActionListener(e-> {
             
                 new ListEspece(res,E.getId(),E.getNom()).show();
                });
             
            
            
            Container Container = new Container(BoxLayout.x());

           placeHolder = EncodedImage.createFromImage(res.getImage("bla.jpg"), true);
           
            String url = "http://localhost/integration-master/test1.1/web/imageEspece/" + E.getImage();
            System.out.print(url);    
            ConnectionRequest connection = new ConnectionRequest();
            connection.setUrl(url);
           URLImage imgurl = URLImage.createToStorage(placeHolder, url, url);

            ImageViewer img = new ImageViewer(imgurl.scaled(400, 400));
            Container.add(img);
            Container.add(InfoContainer);
            
            currentForm.add(Container);
            

          
        }

           Style s = UIManager.getInstance().getComponentStyle("Title");

        TextField searchField = new TextField("", " Search"); // <1>
        searchField.getHintLabel().setUIID("Title");
        searchField.setUIID("Title");
        searchField.getAllStyles().setAlignment(Component.LEFT);
        currentForm.getToolbar().setTitleComponent(searchField);
        FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
        searchField.addDataChangeListener((i1, i2) -> { // <2>
            String t = searchField.getText();
            if (t.length() < 1) {
                for (Component cmp : currentForm.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
            } else {
                t = t.toLowerCase();
                for (Component cmp : currentForm.getContentPane()) {
                    String val = null;
                    if (cmp instanceof Label) {
                        val = ((Label) cmp).getText();
                    } else {
                        if (cmp instanceof TextArea) {
                            val = ((TextArea) cmp).getText();
                        } else {

                            val = (String) cmp.getPropertyValue("text");
                        }
                    }
                    boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
                    cmp.setHidden(!show); // 
                    cmp.setVisible(show);
                }
            }
            currentForm.getContentPane().animateLayout(250);
        });
      /*  for (Formation f : ServiceFormation.getInstance().getAllFormations()) {
      {
            Button btn = new Button(f.getNom());
            currentForm.add(btn);
            btn.addPointerReleasedListener(ev -> {
              //  FormationDetail(f, res).show();
            });
        }
        currentForm.getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
            searchField.startEditingAsync(); // <4>
        });
      

       
       
    
    }*/
    
}
}