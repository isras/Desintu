/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.SalaryDao;
import java.util.List;
import model.Employee;
import model.Salary;

/**
 *
 * @author eyetive
 */
public class SalaryService {
    
    private final SalaryDao salaryDao;
    
    public SalaryService(){
        this.salaryDao = new SalaryDao();
    }
    
    public boolean saveSalary(){
        return this.salaryDao.save();
    }
    
    public boolean updateSalary(){
        return this.salaryDao.update();
    }
    
    public void newInstance(){
        this.salaryDao.newInstance();
    }
    
    public void setInstance(Salary salary){
        this.salaryDao.setInstance(salary);
    }
    
    public Salary getSalary(){
        return this.salaryDao.getSalary();
    }
    
    public List<Salary> list(){
        return this.salaryDao.list();
    }
    
    public List<Salary> getSalaryByEmployee(Employee employee){
        return this.salaryDao.getSalaryByEmployee(employee);
    }
    
}
