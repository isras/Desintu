package controller.service;

import controller.dao.AccountRecordDao;
import java.util.List;
import model.AccountRecord;
import model.ReceivableAccount;

public class AccountRecordService {
    
    private final AccountRecordDao accountRecordDao;
    
    public AccountRecordService(){
        this.accountRecordDao = new AccountRecordDao();
    }
    
    public boolean saveAccountRecord(){
        return this.accountRecordDao.save();
    }
    
    public boolean updateAccountRecord(){
        return this.accountRecordDao.update();
    }
    
    public boolean removeAccountRecord(){
        return this.accountRecordDao.remove();
    }
    
    public void setInstance(AccountRecord accountRecord){
        this.accountRecordDao.setInstance(accountRecord);
    }
    
    public void newInstance(){
        this.accountRecordDao.newInstance();
    }
    
    public AccountRecord getAccountRecord(){
        return this.accountRecordDao.getAccountRecord();
    }
    
    public List<AccountRecord> getAccountRecordList(){
        return this.accountRecordDao.getAccountRecordList();
    }
    
    public void addAccountRecord(AccountRecord accountRecord){
        this.accountRecordDao.addAccountRecord(accountRecord);
    }
    
    public void setAccountRecordList(List<AccountRecord> accountRecordList){
        this.accountRecordDao.setAccountRecordList(accountRecordList);
    }
    
    public List<AccountRecord> list(){
        return this.accountRecordDao.list();
    }
    
    public List<AccountRecord> getAccountRecordListByReceivableAccountIdAndCount(ReceivableAccount receivableAccount){
        return this.accountRecordDao.getAccountRecordListByReceivableAccountIdAndCount(receivableAccount);
    }
}