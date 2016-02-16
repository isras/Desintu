package controller.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.UserAccount;

public class UserAccountDao extends AdapterDao {

    private UserAccount user;
    ConexionBd cone = new ConexionBd();
    Connection conex = null;

    public UserAccountDao() {
        super(UserAccount.class, new Conexion().getEm());//nos permite llamar al constructor de la clase padre
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.user);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean edit() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(this.user);
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
            this.eliminar(this.user);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public UserAccount logIn(String user, String pass) {
        UserAccount c = null;

        try {
            String query = "Select c from UserAccount c where c.usrName ='" + user + "' and c.usrPassword ='" + pass + "'";
            Query q = this.getEntityManager().createQuery(query);
            c = (UserAccount) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return c;
    }

    /**
     * @return the user
     */
    public UserAccount getUserAccount() {
        if (this.user == null) {
            this.user = new UserAccount();
        }
        return user;
    }
    
    public void newInstance(){
        this.user = null;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserAccount user) {
        this.user = user;
    }

    public List<UserAccount> list() {
        List<UserAccount> uAccountList = new ArrayList<>();
        try {
            String query = "Select c from UserAccount c";
            Query q = this.getEntityManager().createQuery(query);
            uAccountList = q.getResultList();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return uAccountList;
    }

}
