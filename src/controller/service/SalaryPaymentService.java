/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.SalaryPaymentDao;
import java.util.List;
import model.Salary;
import model.SalaryPayment;

/**
 *
 * @author eyetive
 */
public class SalaryPaymentService {
    
    private final SalaryPaymentDao salaryPaymentDao;
    
    public SalaryPaymentService(){
        this.salaryPaymentDao = new SalaryPaymentDao();
    }
    
    public boolean saveSalaryPayment(){
        return this.salaryPaymentDao.save();
    }
    
    public boolean updateSalaryPayment(){
        return this.salaryPaymentDao.update();
    }
    
    public void newInstance(){
        this.salaryPaymentDao.newInstance();
    }
    
    public void setInstance(SalaryPayment salaryPayment){
        this.salaryPaymentDao.setInstance(salaryPayment);
    }
    
    public SalaryPayment getSalaryPayment(){
        return this.salaryPaymentDao.getSalaryPayemt();
    }
    
    public List<SalaryPayment> listAll(){
        return this.salaryPaymentDao.listAll();
    }
    
    public List<SalaryPayment> getSalaryPaymentListBySalary(Salary salary){
        return this.salaryPaymentDao.getSalaryPaymentBySalary(salary);
    }
    
    public List<SalaryPayment> getSalaryPaymentList(){
        return this.salaryPaymentDao.getSalaryPaymentList();
    }
    
    public void setSalaryPaymentList(List<SalaryPayment> salaryPaymentList){
        this.salaryPaymentDao.setSalaryPaymentList(salaryPaymentList);
    }
    
    public void addSalaryPaymentToList(SalaryPayment salaryPayment){
        this.salaryPaymentDao.addSalaryPaymentToList(salaryPayment);
    }
    
}
