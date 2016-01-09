package controller.service;

import controller.dao.UserAccountDao;
import java.util.List;
import model.UserAccount;


public class UserAccountService {
    
    private final UserAccountDao userDao;
    
    public UserAccountService(){
        userDao = new UserAccountDao();
    }
    
    public boolean saveUserAccount(){
        return this.userDao.save();
    }
    
    public boolean editUserAccount(){
        return this.userDao.edit();
    }
    
    public void newInstance(){
        this.userDao.newInstance();
    }
    
    public UserAccount logIn(String user_name, String password){
        return this.userDao.logIn(user_name, password);
    }
    
    public UserAccount getUserAccount(){
        return this.userDao.getUserAccount();
    }
    
    public void setInstance(UserAccount user){
        this.userDao.setUser(user);
    }
    
    public List<UserAccount> list(){
        return this.userDao.list();
    }
    
}
