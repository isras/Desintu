/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.dao;

import controller.resources.Operaciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import model.ClosingCash;

/**
 *
 * @author Jhoe
 */
public class CashClosingDao extends AdapterDao {
    
    private ClosingCash cashClosing;
    
    public CashClosingDao(){
        super(ClosingCash.class, new Conexion().getEm());
    }
    
    public boolean save(){
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.cashClosing);
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
            this.modificar(this.cashClosing);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the cashClosing
     */
    public ClosingCash getCashClosing() {
        if(this.cashClosing == null){
            this.cashClosing = new ClosingCash();
        }
        return cashClosing;
    }

    /**
     * @param cashClosing the cashClosing to set
     */
    public void setInstance(ClosingCash cashClosing) {
        this.cashClosing = cashClosing;
    }
    
    public void newInstance(){
        this.cashClosing = null;
    }
    
    public List<ClosingCash> list(){
        List<ClosingCash> cashClosingList = new ArrayList<>();
        try {
            String query = "select c from CashClosing c";
            Query q = this.getEntityManager().createQuery(query);
            cashClosingList= q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return cashClosingList;
    }
    
    public List<ClosingCash> listClosingCashByDateRange(Date startDate, Date finalDate){
        List<ClosingCash> cCashList = new ArrayList<>();
        String ini = Operaciones.formatDate(startDate);
        String fin = Operaciones.formatDate(finalDate);
        try {
            String query = "select c from ClosingCash c where c.ccDateFrom >= '" + ini + "' and c.ccDateTo <= '" + fin + "'";
            Query q = this.getEntityManager().createQuery(query);
            cCashList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return cCashList;
    }
    
    
    
}
