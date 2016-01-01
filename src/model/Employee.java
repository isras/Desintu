/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eyetive
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "emp_job")
    private String employeeJob;
    @Column(name = "emp_hire_date")
    @Temporal(TemporalType.DATE)
    private Date employeeHireDate;
    @Column(name = "emp_departure_date")
    @Temporal(TemporalType.DATE)
    private Date employeeDepartureDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Salary> salaryList;
    @JoinColumn(name = "emp_person_id", referencedColumnName = "person_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Person person;

    public Employee() {
        this.salaryList = new ArrayList<>();
    }

    public Employee(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(person.getPrFirstName()).append(" ").append(person.getPrLastName()).toString();
    }

    /**
     * @return the employeeHireDate
     */
    public Date getEmployeeHireDate() {
        return employeeHireDate;
    }

    /**
     * @param employeeHireDate the employeeHireDate to set
     */
    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    /**
     * @return the employeeDepartureDate
     */
    public Date getEmployeeDepartureDate() {
        return employeeDepartureDate;
    }

    /**
     * @param employeeDepartureDate the employeeDepartureDate to set
     */
    public void setEmployeeDepartureDate(Date employeeDepartureDate) {
        this.employeeDepartureDate = employeeDepartureDate;
    }

    public List<Salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }
}
