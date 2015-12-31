/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import views.EyetivePrincipal;

/**
 *
 * @author Isra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         try {
            //            JFrame.setDefaultLookAndFeelDecorated(true);
            //            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.SaharaSkin");
            ////Blue Ice
            //Blue Moon
            //WhiteVision
            //Simple2D
            //
            //UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());            
            new EyetivePrincipal().setVisible(true);
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
