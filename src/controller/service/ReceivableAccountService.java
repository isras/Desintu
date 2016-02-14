/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.ReceivableAccountDao;
import java.util.List;
import model.Person;
import model.ReceivableAccount;

/**
 *
 * @author eyetive
 */
public class ReceivableAccountService {
    private final ReceivableAccountDao receivableAccountDao;
    
    public ReceivableAccountService(){
        this.receivableAccountDao = new ReceivableAccountDao();
    }
    
    public boolean saveReceivableAccount(){
        return this.receivableAccountDao.save();
    }
    
    public boolean updateReceivableAccount(){
        return this.receivableAccountDao.update();
    }
    
    public boolean removeReceivableAccount(){
        return this.receivableAccountDao.remove();
    }
    
    public void setInstance(ReceivableAccount receivableAccount){
        this.receivableAccountDao.setInstance(receivableAccount);
    }
    
    public void newInstance(){
        this.receivableAccountDao.newInstance();
    }
    
    public ReceivableAccount getReceivableAccount(){
        return this.receivableAccountDao.getReceivableAccount();
    }
    
    public List<ReceivableAccount> getReceivableAccountList(){
        return this.receivableAccountDao.getReceivableAccountList();
    }
    
    public void addReceivableAccountItem(ReceivableAccount receivableAccount){
        this.receivableAccountDao.addReceivableAccountItem(receivableAccount);
    }
    
    public void setReceivableAccountList(List<ReceivableAccount> receivableAccountList){
        this.receivableAccountDao.setReceivableAccountList(receivableAccountList);
    }
    
    public List<ReceivableAccount> list(){
        return this.receivableAccountDao.list();
    }
    
    public ReceivableAccount getReceivableAccountByPerson(Person person){
        return this.receivableAccountDao.getUniqueReceivableAccountByPerson(person);
    }
}
