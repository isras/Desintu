/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "payroll")
@NamedQueries({
    @NamedQuery(name = "Payroll.findAll", query = "SELECT p FROM Payroll p")})
public class Payroll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payroll_id")
    private Long payrollId;
    @Column(name = "pr_worked_days")
    private Integer payrollWorkedDays;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pr_basic_salary")
    private Double payrollBasicSalary;
    @Column(name = "pr_extra_hours")
    private Double payrollExtraHours;
    @Column(name = "pr_thirtheen_salary")
    private Double payrollThirtheenSalary;
    @Column(name = "pr_fourtteenth_salary")
    private Double payrollFourtteenthSalary;
    @Column(name = "pr_other_income")
    private Double payrollOtherIncome;
    @Column(name = "pr_total_income")
    private Double payrollTotalIncome;
    @Column(name = "pr_iess_contribution")
    private Double payrollIessContribution;
    @Column(name = "pr_salary_advance")
    private Double payrollSalaryAdvance;
    @Column(name = "pr_total_salary")
    private Double payrollTotalSalary;
    @JoinColumn(name = "pr_employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee Employee;

    public Payroll() {
    }

    public Payroll(Long payrollId) {
        this.payrollId = payrollId;
    }

    public Long getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Long payrollId) {
        this.payrollId = payrollId;
    }

    public Integer getPrWorkedDays() {
        return payrollWorkedDays;
    }

    public void setPrWorkedDays(Integer prWorkedDays) {
        this.payrollWorkedDays = prWorkedDays;
    }

    public Double getPayrollBasicSalary() {
        return payrollBasicSalary;
    }

    public void setPayrollBasicSalary(Double payrollBasicSalary) {
        this.payrollBasicSalary = payrollBasicSalary;
    }

    public Double getPayrollExtraHours() {
        return payrollExtraHours;
    }

    public void setPayrollExtraHours(Double payrollExtraHours) {
        this.payrollExtraHours = payrollExtraHours;
    }

    public Double getPayrollThirtheenSalary() {
        return payrollThirtheenSalary;
    }

    public void setPayrollThirtheenSalary(Double payrollThirtheenSalary) {
        this.payrollThirtheenSalary = payrollThirtheenSalary;
    }

    public Double getPayrollFourtteenthSalary() {
        return payrollFourtteenthSalary;
    }

    public void setPayrollFourtteenthSalary(Double payrollFourtteenthSalary) {
        this.payrollFourtteenthSalary = payrollFourtteenthSalary;
    }

    public Double getPayrollOtherIncome() {
        return payrollOtherIncome;
    }

    public void setPayrollOtherIncome(Double payrollOtherIncome) {
        this.payrollOtherIncome = payrollOtherIncome;
    }

    public Double getPayrollTotalIncome() {
        return payrollTotalIncome;
    }

    public void setPayrollTotalIncome(Double payrollTotalIncome) {
        this.payrollTotalIncome = payrollTotalIncome;
    }

    public Double getPayrollIessContribution() {
        return payrollIessContribution;
    }

    public void setPayrollIessContribution(Double payrollIessContribution) {
        this.payrollIessContribution = payrollIessContribution;
    }

    public Double getPayrollSalaryAdvance() {
        return payrollSalaryAdvance;
    }

    public void setPayrollSalaryAdvance(Double payrollSalaryAdvance) {
        this.payrollSalaryAdvance = payrollSalaryAdvance;
    }

    public Double getPayrollTotalSalary() {
        return payrollTotalSalary;
    }

    public void setPayrollTotalSalary(Double payrollTotalSalary) {
        this.payrollTotalSalary = payrollTotalSalary;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee Employee) {
        this.Employee = Employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payrollId != null ? payrollId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payroll)) {
            return false;
        }
        Payroll other = (Payroll) object;
        if ((this.payrollId == null && other.payrollId != null) || (this.payrollId != null && !this.payrollId.equals(other.payrollId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Payroll[ payrollId=" + payrollId + " ]";
    }
    
}
