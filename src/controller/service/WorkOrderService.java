/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.WorkOrderDao;
import java.util.List;
import model.WorkOrder;

/**
 *
 * @author Eyetive
 */
public class WorkOrderService {
    
    private final WorkOrderDao wdao;

    public WorkOrderService() {
        this.wdao = new WorkOrderDao();
    }
    
    public boolean saveWorkOrder(){
        return this.wdao.save();
    }
    
    public boolean updateWorkOrder(){
        return this.wdao.update();
    }
    
    public void newInstace(){
        this.wdao.newInstance();
    }

    public void setInstance(WorkOrder workOrder) {
        this.wdao.setInstance(workOrder);
    }

    public WorkOrder getWorkOrder() {
        return this.wdao.getWorkOrder();
    }
    
    public List<WorkOrder> getWorkOrderList(){
        return this.wdao.getWorkOrderList();
    }
    
    public List<WorkOrder> getWorkOrderListByState(){
        return this.wdao.getWorkOrderListByState();
    }
    
}
