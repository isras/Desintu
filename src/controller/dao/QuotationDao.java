/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Quotation;

/**
 *
 * @author Eyetive
 */
public class QuotationDao extends AdapterDao {
    
    Quotation quotation;
    
    public QuotationDao() {
        super(Quotation.class,new Conexion().getEm());
    }
    
    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.quotation);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(this.quotation);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean delete() {
        return true;
    }

    public void newInstance() {
        this.quotation = null;
    }

    /**
     * @return the quotation
     */
    public Quotation getQuotation() {
        if (this.quotation == null) {
            this.quotation = new Quotation();
        }
        return quotation;
    }

    /**
     * @param quotation the invoice to set
     */
    public void setInstance(Quotation quotation) {
        this.quotation = quotation;
    }

    public List<Quotation> getQuotationList() {
        List<Quotation> quotationList = new ArrayList<>();
        try {
            String query = "select c from Quotation c";
            Query q = this.getEntityManager().createQuery(query);
            quotationList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return quotationList;
    }
    
    public List<Quotation> getQuotationListByNumber(String criteria){
        List<Quotation> quotationList = new ArrayList<>();
        try{
            String query = "select c from Quotation c where c.quotationNumber like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            quotationList = q.getResultList();
        }catch(Exception e){
            System.out.println(e);
        }
        return quotationList;
    }
    
    public List<Quotation> getQuotationListByCustomer(String criteria){
        List<Quotation> quotationList = new ArrayList<>();
        try{
            String query = "select c from Quotation c where c.person.prFirstName like '" + criteria + "%' or c.person.prLastName like '" + criteria + "%' or c.person.prIdentification like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            quotationList = q.getResultList();
        }catch(Exception e){
            System.out.println(e);
        }
        return quotationList;
    }
}
