package controller.service;

import controller.dao.PayrollDao;
import model.Payroll;

public class PayrollService {
    
    private final PayrollDao payrollDao;
    
    public PayrollService(){
        this.payrollDao = new PayrollDao();
    }
    
    public boolean savePayroll(){
        return this.payrollDao.save();
    }
    
    public boolean updatePayroll(){
        return this.payrollDao.update();
    }
    
    public void newInstance(){
        this.payrollDao.newInstance();
    }
    
    public void setInstance(Payroll payroll){
        this.payrollDao.setInstance(payroll);
    }
    
    public Payroll getPayroll(){
        return this.payrollDao.getPayroll();
    }
}
