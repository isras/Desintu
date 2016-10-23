/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eyetive
 */
@Entity
@Table(name = "salary_payment")
@NamedQueries({
    @NamedQuery(name = "SalaryPayment.findAll", query = "SELECT s FROM SalaryPayment s")})
public class SalaryPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salary_payment_id")
    private Long salaryPaymentId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "spa_value")
    private Double salaryPaymentValue;
    @Column(name = "spa_date")
    @Temporal(TemporalType.DATE)
    private Date salaryPaymentDate;
    @Column(name = "spa_description")
    private String salaryPaymentDescription;
    @Column (name = "spa_observation")
    private String salaryPaymentObservation;  
    @JoinColumn(name = "spa_salary_id", referencedColumnName = "salary_id")
    @ManyToOne(optional = false)
    private Salary salary;

    public SalaryPayment() {
    }

    public SalaryPayment(Long salaryPaymentId) {
        this.salaryPaymentId = salaryPaymentId;
    }

    public Long getSalaryPaymentId() {
        return salaryPaymentId;
    }

    public void setSalaryPaymentId(Long salaryPaymentId) {
        this.salaryPaymentId = salaryPaymentId;
    }

    public Double getSalaryPaymentValue() {
        return salaryPaymentValue;
    }

    public void setSalaryPaymentValue(Double salaryPaymentValue) {
        this.salaryPaymentValue = salaryPaymentValue;
    }

    public Date getSalaryPaymentDate() {
        return salaryPaymentDate;
    }

    public void setSalaryPaymentDate(Date salaryPaymentDate) {
        this.salaryPaymentDate = salaryPaymentDate;
    }

    public String getSalaryPaymentDescription() {
        return salaryPaymentDescription;
    }

    public void setSalaryPaymentDescription(String salaryPaymentDescription) {
        this.salaryPaymentDescription = salaryPaymentDescription;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryPaymentId != null ? salaryPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaryPayment)) {
            return false;
        }
        SalaryPayment other = (SalaryPayment) object;
        if ((this.salaryPaymentId == null && other.salaryPaymentId != null) || (this.salaryPaymentId != null && !this.salaryPaymentId.equals(other.salaryPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + salaryPaymentValue;
    }

    /**
     * @return the salaryPaymentObservation
     */
    public String getSalaryPaymentObservation() {
        return salaryPaymentObservation;
    }

    /**
     * @param salaryPaymentObservation the salaryPaymentObservation to set
     */
    public void setSalaryPaymentObservation(String salaryPaymentObservation) {
        this.salaryPaymentObservation = salaryPaymentObservation;
    }
    
}
