package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Rol;

public class RolDao extends AdapterDao {
   
    private Rol rol;
    
    public RolDao(){
        super(Rol.class,new Conexion().getEm());
    }
    
    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.rol);
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
            this.modificar(this.rol);
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
            this.eliminar(this.rol);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        if(this.rol == null){
            this.rol = new Rol();
        }
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public void newInstance(){
        this.rol = null;
    }
    
    public List<Rol> list(){
       List<Rol> rolList = new ArrayList<>();
       try{
           String query = "select c from Rol c";
           Query q = this.getEntityManager().createQuery(query);
           rolList = q.getResultList();
       }catch(Exception e){
           System.out.println("Error en: " + e);
       }
       return rolList;
    }
    
    public List<Rol> listPermitedRol(){
        List<Rol> rolList = new ArrayList<>();
        String name ="SuperAdmin";
       try{
           String query = "select c from Rol c where c.rolName != '" + name + "'";
           Query q = this.getEntityManager().createQuery(query);
           rolList = q.getResultList();
       }catch(Exception e){
           System.out.println("Error en: " + e);
       }
       return rolList;
    }
    
    
    
}
