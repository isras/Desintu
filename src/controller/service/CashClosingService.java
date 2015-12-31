/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.CashClosingDao;
import java.util.Date;
import java.util.List;
import model.ClosingCash;

/**
 *
 * @author Usuario
 */
public class CashClosingService {
    
    private final CashClosingDao ccDao;
    
    public CashClosingService(){
        this.ccDao = new CashClosingDao();
    }
    
    public boolean saveCashClosing(){
        return this.ccDao.save();
    }
    
    public boolean updateCashClosing(){
        return this.ccDao.update();
    }
    
    public void setInstance(ClosingCash cashClosing){
        this.ccDao.setInstance(cashClosing);
    }
    
    public void newInstance(){
        this.ccDao.newInstance();
    }
    
    public ClosingCash getCashClosing(){
        return this.ccDao.getCashClosing();
    }
    
    public List<ClosingCash> list(){
        return this.ccDao.list();
    }
    
    public List<ClosingCash> listClosingCashByDateRange(Date startDate, Date finalDate){
        return this.ccDao.listClosingCashByDateRange(startDate, startDate);
    }
    
}
