package controller.dao;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractDao<T> {

    private T instancia;

    private EntityManager entityManager;
    
    public AbstractDao(T t){
        instancia = t;
        entityManager = DataSource.getEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T getInstancia() {
        return instancia;
    }

    public void setInstancia(T instancia) {
        this.instancia = instancia;
    }

    public void persist() throws Exception{
        this.entityManager.getTransaction().begin();
        try{            
            this.entityManager.persist(instancia);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        }catch(Exception e){
            if (this.entityManager.getTransaction().isActive())
                // Arreglar el Error y reintentar
                this.entityManager.getTransaction().rollback(); 
            throw e;
        }

    }
    
    public void update() throws Exception{
        this.entityManager.getTransaction().begin();
        try{
            instancia = this.entityManager.merge(instancia);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        }catch(Exception e){
            if (this.entityManager.getTransaction().isActive())
                this.entityManager.getTransaction().rollback(); // Arreglar el Error y reiintentar
            throw e;
        }
    }
    
    public void remove() throws Exception{
        this.entityManager.getTransaction().begin();
        try{
            this.entityManager.remove(instancia);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        }catch(Exception e){
            if (this.entityManager.getTransaction().isActive())
                this.entityManager.getTransaction().rollback(); // Arreglar el Error y reiintentar
            throw e;
        }
    }
    
    public T findById(Long id){
        return (T)this.entityManager.find(this.instancia.getClass(), id);
    }
    
    public abstract List<T> searchAll();
   
}
