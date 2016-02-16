/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.AccountingEntryDao;
import java.util.Date;
import java.util.List;
import model.AccountingEntry;

/**
 *
 * @author Usuario
 */
public class AccountingEntryService {
    
    private final AccountingEntryDao aeDao;
    
    public AccountingEntryService(){
        this.aeDao = new AccountingEntryDao();
    }
    
    public boolean saveAccountingEntry(){
        return this.aeDao.save();
    }
    
    public boolean updateAccountingEntry(){
        return this.aeDao.update();
    }
    
    public boolean removeAccountingEntry(){
        return this.aeDao.remove();
    }
    
    public void setInstance(AccountingEntry accountingEntry){
        this.aeDao.setInstance(accountingEntry);
    }
    
    public void newInstance(){
        this.aeDao.newInstance();
    }
    
    public AccountingEntry getAccountingEntry(){
        return this.aeDao.getAccountingEntry();
    }
    
    public List<AccountingEntry> getAccountingEntryList(){
        return this.aeDao.getAccountingEntryList();
    }
    
    public void addAccountingEntryList(AccountingEntry aEntry){
        this.aeDao.addAccountingEntryList(aEntry);
    }
    
    public void setAccountingEntryList(List<AccountingEntry> aEntryList){
        this.aeDao.setAccountingEntryList(aEntryList);
    }
    
    public List<AccountingEntry> list(){
        return this.aeDao.list();
    }
    
    public List<AccountingEntry> listByType(int aEntryType){
        return this.aeDao.listByType(aEntryType);
    }
    
    public List<AccountingEntry> listByCurrentDate(Date currentDate){
        return this.aeDao.listByDate(currentDate);
    }
    
    public List<AccountingEntry> listByDescription(String desc){
        return this.aeDao.listByDescription(desc);
    }
    
    public List<AccountingEntry> listByDateRange(Date startDate, Date finalDate){
        return this.aeDao.listByDateRange(startDate, finalDate);
    }
}
