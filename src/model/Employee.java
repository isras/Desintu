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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Column(name = "emp_first_name")
    private String employeeFirstName;
    @Column(name = "emp_last_name")
    private String employeeLastName;
    @Column(name = "emp_address")
    private String employeeAddress;
    @Column(name = "emp_email")
    private String employeeEmail;
    @Column(name = "emp_phone")
    private String employeePhone;
    @Column(name = "emp_identification")
    private String employeeIdentification;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "Employee")
    private List<Salary> salaryList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "Employee")
    private List<WorkOrder> workOrderList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "Employee")
    private List<Payroll> payrollList;

    public Employee() {
        this.salaryList = new ArrayList<>();
        this.workOrderList = new ArrayList<>();
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
        return sb.append(getEmployeeFirstName()).append(" ").append(getEmployeeLastName()).toString();
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

    public List<WorkOrder> getWorkOrderList() {
        return workOrderList;
    }

    public void setWorkOrderList(List<WorkOrder> workOrderList) {
        this.workOrderList = workOrderList;
    }

    /**
     * @return the employeeFirstName
     */
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    /**
     * @param employeeFirstName the employeeFirstName to set
     */
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    /**
     * @return the employeeLastName
     */
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    /**
     * @param employeeLastName the employeeLastName to set
     */
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    /**
     * @return the employeeAddress
     */
    public String getEmployeeAddress() {
        return employeeAddress;
    }

    /**
     * @param employeeAddress the employeeAddress to set
     */
    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    /**
     * @return the employeeEmail
     */
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /**
     * @param employeeEmail the employeeEmail to set
     */
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    /**
     * @return the employeePhone
     */
    public String getEmployeePhone() {
        return employeePhone;
    }

    /**
     * @param employeePhone the employeePhone to set
     */
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    /**
     * @return the employeeIdentification
     */
    public String getEmployeeIdentification() {
        return employeeIdentification;
    }

    /**
     * @param employeeIdentification the employeeIdentification to set
     */
    public void setEmployeeIdentification(String employeeIdentification) {
        this.employeeIdentification = employeeIdentification;
    }

    public List<Payroll> getPayrollList() {
        return payrollList;
    }

    public void setPayrollList(List<Payroll> payrollList) {
        this.payrollList = payrollList;
    }
}
