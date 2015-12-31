/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author michael
 */
public class DataSource {

    private static EntityManager em = null;

    public static EntityManager getEntityManager(){
        if (em == null || !em.isOpen()){
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("piramiheadPU");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArmoirePU");
            em = emf.createEntityManager();
        }
        return em;
    }
}
