package controller.resources;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public class DesktopPersonalizado extends JDesktopPane{
	private ImageIcon ic;
	private String direccion;	
	public DesktopPersonalizado(String dir) {
		direccion =dir;
	}
        @Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ic=new ImageIcon(getClass().getResource(getDireccion()));
		g.drawImage(ic.getImage(),0,0,this.getWidth(),this.getHeight(),this);
                
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
