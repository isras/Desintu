/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Person;
import model.ReceivableAccount;

/**
 *
 * @author Eyetive Central
 */
public class ReceivableAccountDao extends AdapterDao {

    private ReceivableAccount receivableAccount;
    private List<ReceivableAccount> receivableAccountList;

    public ReceivableAccountDao() {
        super(ReceivableAccount.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.receivableAccount);
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
            this.modificar(this.receivableAccount);
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
            this.eliminar(this.receivableAccount);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public ReceivableAccount getReceivableAccount() {
        if (this.receivableAccount == null) {
            this.receivableAccount = new ReceivableAccount();
        }
        return receivableAccount;
    }

    public void setInstance(ReceivableAccount receivableAccount) {
        this.receivableAccount = receivableAccount;
    }

    public void newInstance() {
        this.receivableAccount = null;
    }

    public List<ReceivableAccount> getReceivableAccountList() {
        if (this.receivableAccountList == null) {
            this.receivableAccountList = new ArrayList<>();
        }
        return receivableAccountList;
    }

    public void addReceivableAccountItem(ReceivableAccount receivableAccount) {
        if (this.receivableAccountList == null) {
            this.receivableAccountList = new ArrayList<>();
        }
        this.receivableAccountList.add(receivableAccount);
        this.receivableAccount = new ReceivableAccount();
    }

    public void setReceivableAccountList(List<ReceivableAccount> receivableAccountList) {
        this.receivableAccountList = receivableAccountList;
    }

    public List<ReceivableAccount> list() {
        List<ReceivableAccount> list = new ArrayList<>();
        try {
            String query = "select c from ReceivableAccount c";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ReceivableAccount getUniqueReceivableAccountByPerson(Person person) {
        ReceivableAccount rAccount = new ReceivableAccount();
        try {
            String query = "select c from ReceivableAccount c where c.person.personId=" + person.getPersonId();
            Query q = this.getEntityManager().createQuery(query);
            rAccount = (ReceivableAccount) q.getSingleResult();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return rAccount;
    }

}
