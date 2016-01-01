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
@Table(name = "salary_advance")
@NamedQueries({
    @NamedQuery(name = "SalaryItem.findAll", query = "SELECT s FROM SalaryAdvance s")})
public class SalaryAdvance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salary_advance_id")
    private Long salaryAdvanceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sad_value")
    private Double salaryAdvanceValue;
    @Column(name = "sad_date")
    @Temporal(TemporalType.DATE)
    private Date salaryAdvanceDate;
    @Column(name = "sad_description")
    private String salaryAdvanceDescription;
    @JoinColumn(name = "sad_salary_id", referencedColumnName = "salary_id")
    @ManyToOne(optional = false)
    private Salary salary;

    public SalaryAdvance() {
    }

    public SalaryAdvance(Long salaryAdvanceId) {
        this.salaryAdvanceId = salaryAdvanceId;
    }

    public Long getSalaryAdvanceId() {
        return salaryAdvanceId;
    }

    public void setSalaryAdvanceId(Long salaryAdvanceId) {
        this.salaryAdvanceId = salaryAdvanceId;
    }

    public Double getSalaryAdvanceValue() {
        return salaryAdvanceValue;
    }

    public void setSalaryAdvanceValue(Double salaryAdvanceValue) {
        this.salaryAdvanceValue = salaryAdvanceValue;
    }

    public Date getSalaryAdvanceDate() {
        return salaryAdvanceDate;
    }

    public void setSalaryAdvanceDate(Date salaryAdvanceDate) {
        this.salaryAdvanceDate = salaryAdvanceDate;
    }

    public String getSalaryAdvanceDescription() {
        return salaryAdvanceDescription;
    }

    public void setSalaryAdvanceDescription(String salaryAdvanceDescription) {
        this.salaryAdvanceDescription = salaryAdvanceDescription;
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
        hash += (salaryAdvanceId != null ? salaryAdvanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaryAdvance)) {
            return false;
        }
        SalaryAdvance other = (SalaryAdvance) object;
        if ((this.salaryAdvanceId == null && other.salaryAdvanceId != null) || (this.salaryAdvanceId != null && !this.salaryAdvanceId.equals(other.salaryAdvanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SalaryItem[ salaryAdvanceId=" + salaryAdvanceId + " ]";
    }
    
}
