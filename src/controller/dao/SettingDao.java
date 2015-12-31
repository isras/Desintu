package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Setting;

public class SettingDao extends AdapterDao  {
    
    private Setting setting;
    
    public SettingDao(){
        super(Setting.class, new Conexion().getEm());
    }
    
    public boolean save(){
       boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.setting);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }
    
    public boolean update(){
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(this.setting);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the setting
     */
    public Setting getSetting() {
        if(this.setting == null){
            this.setting = new Setting();
        }
        return setting;
    }

    /**
     * @param setting the setting to set
     */
    public void setInstance(Setting setting) {
        this.setting = setting;
    }
    
    public void newInstance(){
        this.setting = null;
    }
    
    public List<Setting> list(){
        List<Setting> list = new ArrayList<>();
        try {
            String query = "select c from Setting c";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Setting getUniqueSetting(){
        Setting set = new Setting();
         try {
            String query = "select c from Setting c";
            Query q = this.getEntityManager().createQuery(query);
            set = (Setting) q.getSingleResult();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
         return set;
    }
}
