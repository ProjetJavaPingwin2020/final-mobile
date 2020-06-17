/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiForm;

import Services.ServiceCatEspece;

import static com.codename1.charts.util.ColorUtil.CYAN;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author asus
 */
public class addCatEspece extends BaseFormback{

    public static TextField nom;
    public static Picker dPicker;
    Form f;
    String path;
    Button btnajout;
    ComboBox<String> combo = new ComboBox<>();

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public addCatEspece(Resources res) {
        super("Newsfeed", BoxLayout.y());

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Categorie Espece");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        tb.addSearchCommand(e -> {
        });

        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 5) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 5);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                        GridLayout.encloseIn(3, FlowLayout.encloseCenter(new Label(res.getImage(""), "PictureWhiteBackgrond")))
                )
        ));

    
        TextField nomt = new TextField("", "Nom", 20, TextField.ANY);
        nomt.getAllStyles().setFgColor(0x000000);

        add(nomt);
        
        Button send = new Button("Ajouter");
        
        add(send);
        
        send.addActionListener(l->{
        
            if ((nomt.getText()!= null) || (nomt.getText().length() < 4) )
            {
                
            if(ServiceCatEspece.getInstance().Add(nomt.getText())){
                
                Dialog.show("Success", " succès", new Command("OK"));

            
            }else{
                
                
            Dialog.show("Error", " Failed", new Command("OK"));

            
            }
            
            
            }else{
                
           Dialog.show("Error", "Verifer le champ name !!!", new Command("OK"));

            }
               
        
        });
        
        
  
    

    }

}
