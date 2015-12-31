package controller.dao;

import java.util.ArrayList;
import java.util.List;
import model.Detail;

/**
 *
 * @author Usuario
 */
public class DetailDao extends AdapterDao {

    private Detail detail;
    private List<Detail> detailList;

    public DetailDao() {
        super(Detail.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.detail);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean save(Detail detail) {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(detail);
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
            this.modificar(this.detail);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }
    
    public boolean update(Detail detail) {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(detail);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }
    
        public boolean remove(){
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            Detail ref = this.getEntityManager().getReference(Detail.class, detail.getDetailId());
            this.eliminar(ref);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public void newInstance() {
        this.detail = null;
    }

    /**
     * @return the detail
     */
    public Detail getDetail() {
        if (this.detail == null) {
            this.detail = new Detail();
        }
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setInstance(Detail detail) {
        this.detail = detail;
    }

    public List<Detail> getDetailList() {
        if (this.detailList == null) {
            this.detailList = new ArrayList<>();
        }
        return this.detailList;
    }

    public void addDetailList(Detail detail) {
        if(this.detailList == null){
            this.detailList = new ArrayList<>();
        }
        this.detailList.add(detail);
        this.detail = new Detail();
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
}
