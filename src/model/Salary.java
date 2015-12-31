/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Basic(optional = false)
    @Column(name = "salary_id")
    private Long salaryId;
    @Column(name = "sa_date")
    @Temporal(TemporalType.DATE)
    private Date saDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sa_value")
    private Double saValue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salary")
    private List<SalaryAdvance> salaryItemList;

    public Salary() {
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

    public Date getSaDate() {
        return saDate;
    }

    public void setSaDate(Date saDate) {
        this.saDate = saDate;
    }

    public Double getSaValue() {
        return saValue;
    }

    public void setSaValue(Double saValue) {
        this.saValue = saValue;
    }

    public List<SalaryAdvance> getSalaryItemList() {
        return salaryItemList;
    }

    public void setSalaryItemList(List<SalaryAdvance> salaryItemList) {
        this.salaryItemList = salaryItemList;
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
    
}
