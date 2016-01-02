package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Clase que contiene todas métodos para el acceso a la base de datos
 * @author Sergio
 * @param <T>
 */
public class AdapterDao<T> implements InterfaceDao<T>{
    /**
     * Variable privada: Clase
     */
    private Class<T> clazz;
    /**
     * Variable privada: Manejador de la entidad
     */
    private EntityManager entityManager;
    
    
    /**
     * Contructor de la clase
     * @param clazz clase
     * @param entityManager manejador de la entidad 
     */
    public AdapterDao(Class<T> clazz, EntityManager entityManager)
    {
        this.clazz = clazz;
        this.entityManager = entityManager;
    }
    /**
     * Método para obtener un objeto
     * @param id id del objeto
     * @return T clase tipo generico
     */
    @Override
    public T obterner(Long id) {
        return entityManager.find(clazz, id);
    }
    /**
     * Método que nos devuelve una lista con todos los objetos relacionados
     * @return retorna una lista de un objeto específico 
     */
    @Override
    public List<T> lista() {
        List lista = new ArrayList();
        try {
            Query q = entityManager.createQuery(" Select t from " + clazz.getName() + " t ");
            lista = q.getResultList();
        } catch (Exception e) {
            System.out.println("Error al listado"+e);
        }
        return lista;
    }
    /**
     * Método que te devuelve el id de un objeto
     * @return long devuelve una variable de tipo long 
     */
    @Override
    public long contraTodos() {
        long aux = 0;
        try {
            Query q = entityManager.createQuery(" Select t from " + clazz.getName() + "t");
            aux = q.getResultList().size();
        } catch (Exception e) {
            System.out.println(e);
        }
        return aux;
    }
    /**
     * Método que sirve para guardar un objeto relacionado
     * @param obj recibe el objeto 
     */
    @Override
    public void guarda(T obj){
        entityManager.persist(obj);
    }
    /**
     * Método que permite modificar un objeto relacionada a la instancia actual
     * @param obj recibe un objeto de tipo n 
     */
    @Override
    public void modificar(T obj){
        entityManager.merge(obj);
    }
    /**
     * Método que te permite eliminar un objeto relacionado a la instancia actual
     * @param obj recibe el objeto de tipo n 
     */
    @Override
    public void eliminar(T obj){
        entityManager.remove(obj);
    }
    
    @Override
    public void detach(T obj){
        entityManager.detach(obj);
    }
    
    @Override
    public void refresh(T obj){
        entityManager.refresh(obj);
    }
    
    @Override
    public void flush(){
        entityManager.flush();
    }
    
    /**
     * 
     * @return EntityManager retorna un manejador de entidad 
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}

