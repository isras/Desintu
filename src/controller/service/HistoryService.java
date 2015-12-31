package controller.service;

import controller.dao.HistoryDao;
import model.History;

public class HistoryService {
    private final HistoryDao historyDao;
    
    public HistoryService(){
        historyDao = new HistoryDao();
    }
    
    public boolean save(){
        return false; //this.historyDao.save();
    }
    
    public boolean edit(){
        return this.historyDao.edit();
    }
    
    public History getHistoryPerUser(Long user_id){
        return null; //this.historyDao.getHistoryPerUser(user_id);
    }
    
    public History getHistory(){
        return this.historyDao.getHistory();
    }
    
    public void newInstance(History history){
        this.historyDao.setHistory(history);
    } 
}
