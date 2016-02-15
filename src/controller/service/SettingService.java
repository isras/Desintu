/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.SettingDao;
import java.util.List;
import model.Setting;

/**
 *
 * @author Usuario
 */
public class SettingService {
    
    private final SettingDao sDao;
    
    public SettingService(){
        this.sDao = new SettingDao();
    }
    
    public boolean saveSetting(){
        return this.sDao.save();
    }
    
    public boolean updateSetting(){
        return this.sDao.update();
    }
    
    public void setInstance(Setting setting){
        this.sDao.setInstance(setting);
    }
    
    public Setting getSetting(){
        return this.sDao.getSetting();
    }
    
    public void newInstance(){
        this.sDao.newInstance();
    }
    
    public List<Setting> list(){
        return this.sDao.list();
    }
    
    public Setting getUniqueSetting(){
        return this.sDao.getUniqueSetting();
    }
    
    
}
