package controller.service;

import controller.dao.WorkOrderDao;
import java.util.List;
import model.Person;
import model.WorkOrder;

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
    
    public boolean removeWorkOrder(){
        return this.wdao.delete();
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
    
    public List<WorkOrder> getWorkOrderListByNumber(String criteria){
        return this.wdao.getWorkOrderListByNumber(criteria);
    }
    
    public List<WorkOrder> getWorkOrderListByState(){
        return this.wdao.getWorkOrderListByState();
    }
    
    public List<WorkOrder> getWorkOrderListByCustomerCriteria(String criteria){
        return this.wdao.getWorkOrderListByCustomerCriteria(criteria);
    }
    
     public List<WorkOrder> getWorkOrderListByEmployeeCriteria(String criteria){
        return this.wdao.getWorkOrderListByEmployeeCriteria(criteria);
    }
     
    public List<WorkOrder> getWorkOrderByCustomerAndInvoiceState(Person person){
        return this.wdao.getWorkOrderByCustomerAndInvoiceState(person);
    }
    
    public List<WorkOrder> getWorkOrderByCustomerCountState(Person person, Integer count){
        return this.wdao.getWorkOrderByCustomerCountState(person, count);
    }
    
}
