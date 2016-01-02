/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Employee;
import model.Salary;

/**
 *
 * @author eyetive
 */
public class SalaryDao extends AdapterDao {
    
    private Salary salary;
    private List<Salary> salaryList;

    public SalaryDao() {
        super(Salary.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.salary);
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
            this.guarda(this.salary);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos
            this.detach(salary);
            this.modificar(salary);
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the salary
     */
    public Salary getSalary() {
        if (this.salary == null) {
            this.salary = new Salary();
        }
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setInstance(Salary salary) {
        this.salary = salary;
    }

    public void newInstance() {
        this.salary = null;
    }

    public List<Salary> listAll() {
        List<Salary> list = new ArrayList<>();
        try {
            String query = "select c from Salary c";
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Salary> getSalaryByEmployee(Employee emp) {
        List<Salary> list = new ArrayList<>();
        try {
            String query = "select c from Salary c where c.employee.employeeId = " + emp.getEmployeeId();
            Query q = this.getEntityManager().createQuery(query);
            list = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * @return the listAll
     */
    public List<Salary> getSalaryList() {
        if(this.salaryList == null){
            this.salaryList = new ArrayList<>();
        }
        return salaryList;
    }

    /**
     * @param salaryList the listAll to set
     */
    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }
    
    public void addSalaryToList(Salary salary){
        if(this.salaryList == null){
            this.salaryList = new ArrayList<>();
        }
        this.salaryList.add(salary);
        this.salary = new Salary();
    }
}
