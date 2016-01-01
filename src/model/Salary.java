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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eyetive
 */
@Entity
@Table(name = "salary")
@NamedQueries({
    @NamedQuery(name = "Salary.findAll", query = "SELECT s FROM Salary s")})
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salary_id")
    private Long salaryId;
    @Column(name = "sa_date")
    @Temporal(TemporalType.DATE)
    private Date salaryDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sa_value")
    private Double salaryValue;
    
    @JoinColumn(name = "sa_employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employee employee;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salary")
    private List<SalaryAdvance> salaryAdvanceList;

    public Salary() {
        this.salaryAdvanceList = new ArrayList<>();
    }

    public Salary(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    public Double getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(Double salaryValue) {
        this.salaryValue = salaryValue;
    }

    public List<SalaryAdvance> getSalaryAdvanceList() {
        return salaryAdvanceList;
    }

    public void setSalaryAdvanceList(List<SalaryAdvance> salaryAdvanceList) {
        this.salaryAdvanceList = salaryAdvanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryId != null ? salaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salary)) {
            return false;
        }
        Salary other = (Salary) object;
        if ((this.salaryId == null && other.salaryId != null) || (this.salaryId != null && !this.salaryId.equals(other.salaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Salary[ salaryId=" + salaryId + " ]";
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
