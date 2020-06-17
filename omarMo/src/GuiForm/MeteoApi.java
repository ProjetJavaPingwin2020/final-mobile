/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiForm;

import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author TH3OMAR
 */
public class MeteoApi extends BaseForm{

    public MeteoApi(Resources res) {
           super("", BoxLayout.yCenter());

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Meteo");
        getContentPane().setScrollVisible(false);

       
        BrowserComponent browser = new BrowserComponent();
        browser.setURL("https://www.tameteo.com/meteo_Tunis-Afrique-Tunisie-Tunis-DTTA-1-8952.html");
          add(browser);
    }
    
    
}
