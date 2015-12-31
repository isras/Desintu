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

/**
 *
 * @author eyetive
 */
public class EmployeeDao extends AdapterDao {
    

    private Employee employee;

    public EmployeeDao() {
        super(Employee.class, new Conexion().getEm());
    }

    public boolean save() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.guarda(this.employee);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    public boolean edit() {
        boolean flag = false;
        try {
            this.getEntityManager().getTransaction().begin();
            this.modificar(this.employee);
            this.getEntityManager().getTransaction().commit();//commmit enviado a la datos  
            flag = true;
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        if (this.employee == null) {
            this.employee = new Employee();
        }
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setInstance(Employee employee) {
        this.employee = employee;
    }

    public void newInstance() {
        this.employee = null;
    }

    public List<Employee> list() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            String query = "select c from Employee c";
            Query q = this.getEntityManager().createQuery(query);
            employeeList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        return employeeList;
    }

    public List<Employee> getEmployeesByCriteria(String criteria) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            String query = "select c from Employee c where c.person.prFirstName like '" + criteria + "%' or c.person.prLastName like '" + criteria + "%' or c.person.prIdentification like '" + criteria + "%'";
            Query q = this.getEntityManager().createQuery(query);
            employeeList = q.getResultList();//una obtener todos los objetos que estan guardados en la tabla de la base de datos 
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(employeeList);
        return employeeList;
    }

    public boolean employeeExists(String identification) {
        boolean flag = false;
        try {
            String query = "select c from Employee c where c.prIdentification='" + identification + "'";
            Query q = this.getEntityManager().createQuery(query);
            //p = (Person) q.getSingleResult()
            flag = !q.getResultList().isEmpty(); //una obtener todos los objetos que estan guardados en la tabla de la base de datos
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        return flag;
    }


    
}
