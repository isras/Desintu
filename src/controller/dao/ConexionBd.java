package controller.dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBd {
private Connection conexion = null;

   public Connection conectate(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //setConexion(DriverManager.getConnection("jdbc:mysql://68.178.217.15/armoireBd","armoireBd","Eyetive@2013"));
            setConexion(DriverManager.getConnection("jdbc:mysql://localhost/armoire","root","Eyetive@2015"));
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException cnf){
            JOptionPane.showMessageDialog(null,"No se establecio la conexion");
            setConexion(null);
            return getConexion();
        }
             return getConexion();
    }
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}