package controller.service;

import controller.dao.RolDao;
import java.util.List;
import model.Rol;

public class RolService {

    private final RolDao rolDao;
    
    public RolService(){
        this.rolDao = new RolDao();
    }
    
    public boolean saveRol(){
        return this.rolDao.save();
    }
    
    public boolean updateRol(){
        return this.rolDao.update();
    }
    
    public boolean removeRol(){
        return this.rolDao.remove();
    }
    
    public Rol getRol(){
        return this.rolDao.getRol();
    }
    
    public void setInstance(Rol rol){
        this.rolDao.setRol(rol);
    }
    
    public void newInstance(){
        this.rolDao.newInstance();
    }
    
    public List<Rol> list(){
        return this.rolDao.list();
    }
    
    public List<Rol> listPermitedRol(){
        return this.rolDao.listPermitedRol();
    }
    
}
