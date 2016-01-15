package views.tableModel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class BlackTabbedPane extends JTabbedPane {
    
    BlackTabbedPaneUI blackTabbedPaneUI = new BlackTabbedPaneUI();
    /**
     * Constructor de clase
     */
    public BlackTabbedPane(){
        this.setPreferredSize( new Dimension(100,100) );
        this.setForeground(new Color(255, 255, 255));
        this.setUI( blackTabbedPaneUI );
        this.setVisible(true);
    }
    
    public void setTabSelectedColor( Color color )
    {
        blackTabbedPaneUI.colorSel = color;
        blackTabbedPaneUI.colorContentBorder=color;
    }
    
    public Color getTabSelectedColor()
    {        
        return ( blackTabbedPaneUI.colorSel==null)? new Color(0,0,0): blackTabbedPaneUI.colorSel ;
    }
    
    public void setTabUnselectedColor( Color color )
    {
        blackTabbedPaneUI.colorUnSel = color;        
    }
    
    public Color getTabUnselectedColor()
    {        
        return ( blackTabbedPaneUI.colorUnSel==null)? new Color(192,192,192): blackTabbedPaneUI.colorUnSel ;
    }
    
}//-->
