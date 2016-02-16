/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.WorkOrder;

/**
 *
 * @author Eyetive
 */
public class WorkOrderDao extends AdapterDao {
    
    WorkOrder workOrder;
    
    public WorkOrderDao() {
        super(WorkOrder.class,new Conexion().getEm());
    }
    
    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.workOrder);
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
            this.modificar(this.workOrder);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.eliminar(this.workOrder);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public void newInstance() {
        this.workOrder = null;
    }

    /**
     * @return the workOrder
     */
    public WorkOrder getWorkOrder() {
        if (this.workOrder == null) {
            this.workOrder = new WorkOrder();
        }
        return workOrder;
    }

    /**
     * @param workOrder the invoice to set
     */
    public void setInstance(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public List<WorkOrder> getWorkOrderList() {
        List<WorkOrder> workOrderList = new ArrayList<>();
        try {
            String query = "select c from WorkOrder c";
            Query q = this.getEntityManager().createQuery(query);
            workOrderList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return workOrderList;
    }
    
    public List<WorkOrder> getWorkOrderListByState(){
        List<WorkOrder> workOrderList = new ArrayList<>();
       int state = 1;
        try {
            String query = "select c from WorkOrder c where c.workOrderState = '" + state + "'";
            Query q = this.getEntityManager().createQuery(query);
            workOrderList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return workOrderList;
    }
    
    public List<WorkOrder> getWorkOrderListByNumber(String criteria){
        List<WorkOrder> workOrderList = new ArrayList<>();
        try{
            String query ="select c from WorkOrder c where c.workOrderNumber like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            workOrderList = q.getResultList();
        }catch(Exception e){
            System.out.println(e);
        }
        return workOrderList;
    }
    
    public List<WorkOrder> getWorkOrderListByCustomerCriteria(String criteria){
        List<WorkOrder> workOrderList = new ArrayList<>();
        try{
            String query = "select c from WorkOrder c where c.person.prFirstName like '" + criteria + "%' or c.person.prLastName like '" + criteria + "%' or c.person.prIdentification like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            workOrderList = q.getResultList();
        }catch(Exception e){
            System.out.println(e);
        }
        return workOrderList;
    }
    
    public List<WorkOrder> getWorkOrderListByEmployeeCriteria(String criteria){
        List<WorkOrder> workOrderList = new ArrayList<>();
        try{
            String query = "select c from WorkOrder c where c.employee.person.prFirstName like '" + criteria + "%' or c.employee.person.prLastName like '" + criteria + "%' or c.employee.person.prIdentification like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            workOrderList = q.getResultList();
        }catch(Exception e){
            System.out.println(e);
        }
        return workOrderList;
    }
}
