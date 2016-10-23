package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.AccountRecord;
import model.ReceivableAccount;

/**
 *
 * @author eyetive
 */
public class AccountRecordDao extends AdapterDao {

    private AccountRecord accountRecord;
    private List<AccountRecord> accountRecordList;

    public AccountRecordDao() {
        super(AccountRecord.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.accountRecord);
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
            this.modificar(this.accountRecord);
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
            this.eliminar(this.accountRecord);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public AccountRecord getAccountRecord() {
        if (this.accountRecord == null) {
            this.accountRecord = new AccountRecord();
        }
        return this.accountRecord;
    }

    public void setInstance(AccountRecord accountRecord) {
        this.accountRecord = accountRecord;
    }

    public void newInstance() {
        this.accountRecord = null;
    }

    public List<AccountRecord> getAccountRecordList() {
        if (this.accountRecordList == null) {
            this.accountRecordList = new ArrayList<>();
        }
        return accountRecordList;

    }

    public void addAccountRecord(AccountRecord accountRecord) {
        if (this.accountRecordList == null) {
            this.accountRecordList = new ArrayList<>();
        }
        accountRecordList.add(accountRecord);
        this.accountRecord = new AccountRecord();
    }
    
    public void setAccountRecordList(List<AccountRecord> accountRecordList){
        this.accountRecordList = accountRecordList;
    }
    
    public List<AccountRecord> list() {
        List<AccountRecord> list = new ArrayList<>();
        try {
            String query = "select c from AccountRecord c";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
     public List<AccountRecord> getAccountRecordListByReceivableAccountIdAndCount(ReceivableAccount receivableAccount) {
        List<AccountRecord> list = new ArrayList<>();
        try {
            String query = "select c from AccountRecord c where c.accountRecordCount = " + receivableAccount.getReceivableAccountCount() + " and c.receivableAccount.receivableAccountId = " + receivableAccount.getReceivableAccountId();
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}