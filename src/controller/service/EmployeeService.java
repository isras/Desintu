/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.EmployeeDao;
import java.util.List;
import model.Employee;

/**
 *
 * @author eyetive
 */
public class EmployeeService {
   
    private final EmployeeDao employeeDao;

    public EmployeeService() {
        employeeDao = new EmployeeDao();
    }

    public boolean saveEmployee() {
        return this.employeeDao.save();
    }

    public boolean updateEmployee() {
        return this.employeeDao.edit();
    }

    public Employee getEmployee() {
        return this.employeeDao.getEmployee();
    }

    public void setInstance(Employee employee) {
        this.employeeDao.setInstance(employee);
    }

    public void newInstance() {
        this.employeeDao.newInstance();
    }

    public List<Employee> list() {
        return this.employeeDao.listAll();
    }
    
    public List<Employee> getEmployeesByCriteria(String criteria){
        return this.employeeDao.getEmployeesByCriteria(criteria);
    }
    
    public boolean employeeExists(String identification){
        return this.employeeDao.employeeExists(identification);
    }
    
    public List<Employee> getEmployeeList(){
        return this.employeeDao.getEmployeeList();
    }
    
    public void setEmployeeList(List<Employee> employeeList){
        this.employeeDao.setEmployeeList(employeeList);
    }
    
    public void addEmployeeToList(Employee employee){
        this.employeeDao.addEmployeeToList(employee);
    }
    
}
