package controller.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que contiene métodos que permiten conectar a la base de datos
 * @author Sergio
 */
public class Conexion {
    /**
     * Conecta la base de datos
     */
    private EntityManager em;
    /**
     * Encargado de manejar las transacciones 
     */
    private EntityManagerFactory emf;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public final void setap(){
        this.emf = Persistence.createEntityManagerFactory("ArmoirePU");
        this.em = this.emf.createEntityManager();
    }

    public Conexion() {
        this.setap();
    }
    public static void main(String[]args){
        Conexion conexion = new Conexion();
        
    }
    
}

