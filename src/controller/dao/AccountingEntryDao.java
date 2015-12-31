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
import model.AccountingEntry;

/**
 *
 * @author Usuario
 */
public class AccountingEntryDao extends AdapterDao {

    private AccountingEntry accountingEntry;
    private List<AccountingEntry> accountingEntryList;

    public AccountingEntryDao() {
        super(AccountingEntry.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.accountingEntry);
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
            this.modificar(this.accountingEntry);
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
            this.eliminar(this.accountingEntry);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the accountingEntry
     */
    public AccountingEntry getAccountingEntry() {
        if (this.accountingEntry == null) {
            this.accountingEntry = new AccountingEntry();
        }
        return accountingEntry;
    }

    /**
     * @param accountingEntry the accountingEntry to set
     */
    public void setInstance(AccountingEntry accountingEntry) {
        this.accountingEntry = accountingEntry;
    }

    public void newInstance() {
        this.accountingEntry = null;
    }

    /**
     * @return the accountingEntryList
     */
    public List<AccountingEntry> getAccountingEntryList() {
        if (this.accountingEntryList == null) {
            this.accountingEntryList = new ArrayList<>();
        }
        return accountingEntryList;
    }

    public void addAccountingEntryList(AccountingEntry aEntry) {
        if (this.accountingEntryList == null) {
            this.accountingEntryList = new ArrayList<>();
        }
        this.accountingEntryList.add(aEntry);
        this.accountingEntry = new AccountingEntry();
    }

    /**
     * @param accountingEntryList the accountingEntryList to set
     */
    public void setAccountingEntryList(List<AccountingEntry> accountingEntryList) {
        this.accountingEntryList = accountingEntryList;
    }

    public List<AccountingEntry> list() {
        List<AccountingEntry> aEntryList = new ArrayList<>();
        try {
            String query = "select c from AccountingEntry c";
            Query q = this.getEntityManager().createQuery(query);
            aEntryList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return aEntryList;
    }

    public List<AccountingEntry> listByType(int aEntryType) {
        List<AccountingEntry> aEntryList = new ArrayList<>();
        try {
            String query = "select c from AccountingEntry c where c.aeType ='" + aEntryType + "'";
            Query q = this.getEntityManager().createQuery(query);
            aEntryList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return aEntryList;
    }

    public List<AccountingEntry> listByDate(Date date) {
        List<AccountingEntry> aEntryList = new ArrayList<>();
        try {
            String query = "select c from AccountingEntry c where c.aeCreatedDate ='" + Operaciones.formatDate(date) + "'";
            Query q = this.getEntityManager().createQuery(query);
            aEntryList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return aEntryList;
    }

    public List<AccountingEntry> listByDescription(String desc) {
        List<AccountingEntry> aEntryList = new ArrayList<>();
        try {
            String query = "select c from AccountingEntry c where c.aeDescription  LIKE '%" + desc + "%'";
            Query q = this.getEntityManager().createQuery(query);
            aEntryList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return aEntryList;
    }

    public List<AccountingEntry> listByDateRange(Date startDate, Date finalDate) {
        List<AccountingEntry> aEntryList = new ArrayList<>();
        String ini = Operaciones.formatDate(startDate);
        String fin = Operaciones.formatDate(finalDate);
        try {
            String query = "select c from AccountingEntry c where c.aeCreatedDate >= '" + ini + "' and c.aeCreatedDate <= '" + fin + "'";
            Query q = this.getEntityManager().createQuery(query);
            aEntryList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return aEntryList;
    }

}
