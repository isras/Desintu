/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Petition;

/**
 *
 * @author Jhoe
 */
public class PetitionDao extends AdapterDao {
    
    private Petition petition;
    
    public PetitionDao(){
        super(Petition.class,new Conexion().getEm());
    } 
    
    public boolean save(){
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.petition);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }
    
    public boolean update(){
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(this.petition);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }
    
    public boolean remove() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            Petition ref = this.getEntityManager().getReference(Petition.class, petition.getPetitionId());
            //this.getEntityManager().remove(detail);
            this.eliminar(ref);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the petition
     */
    public Petition getPetition() {
        if(this.petition == null){
            this.petition = new Petition();
        }
        return this.petition;
    }
    
    public void newInstance(){
        this.petition = null;
    }

    /**
     * @param petition the petition to set
     */
    public void setInstance(Petition petition) {
        this.petition = petition;
    }
    
    public List<Petition> getPetitionList(){
        List<Petition> petitionList = new ArrayList<>();
        try {
            String query = "select c from Petition c";
            Query q = this.getEntityManager().createQuery(query);
            petitionList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return petitionList;
    }
    
    public Petition getPetitionPerName(String petitionName){
        Petition p = null;
        try {
            String query = "select p from Petition p where p.ptName='"+petitionName+"'";
            Query q = this.getEntityManager().createQuery(query);
            p = (Petition) q.getSingleResult();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }
    
    public Petition getPetitionPerPersonId(Long personId){
        Petition p = null;
        try {
            String query = "select p from Petition p where p.person.personId="+personId;
            Query q = this.getEntityManager().createQuery(query);
            p = (Petition) q.getSingleResult();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
        
    }
    
      public List<Petition> getPetitionListPerName(String petitionName){
        List<Petition> petitionList = new ArrayList<>();
        try {
            String query = "select c from Petition c where c.ptName='"+petitionName+"'";
            Query q = this.getEntityManager().createQuery(query);
            petitionList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return petitionList;
    }
}
