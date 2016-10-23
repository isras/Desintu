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
 * @author Eyetive Central
 */
@Entity
@Table(name = "receivable_account")
@NamedQueries({
    @NamedQuery(name = "ReceivableAccount.findAll", query = "SELECT r FROM ReceivableAccount r")})
public class ReceivableAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "receivable_account_id")
    private Long receivableAccountId;
    @Column (name = "ra_count")
    private Integer receivableAccountCount;
    @Column(name = "ra_date")
    @Temporal(TemporalType.DATE)
    private Date receivableAccountDate;
    @Column(name = "ra_update_date")
    @Temporal(TemporalType.DATE)
    private Date receivableAccountUpdateDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ra_total")
    private Double receivableAccountTotal;
    @JoinColumn(name = "ra_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person person;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "receivableAccount")
    private List<AccountRecord> accountRecordList;

    public ReceivableAccount() {
        this.accountRecordList = new ArrayList<>();
    }

    public ReceivableAccount(Long receivableAccountId) {
        this.receivableAccountId = receivableAccountId;
    }

    public Long getReceivableAccountId() {
        return receivableAccountId;
    }

    public void setReceivableAccountId(Long receivableAccountId) {
        this.receivableAccountId = receivableAccountId;
    }

    public Date getReceivableAccountDate() {
        return receivableAccountDate;
    }

    public void setReceivableAccountDate(Date receivableAccountDate) {
        this.receivableAccountDate = receivableAccountDate;
    }

    public Date getReceivableAccountUpdateDate() {
        return receivableAccountUpdateDate;
    }

    public void setReceivableAccountUpdateDate(Date receivableAccountUpdateDate) {
        this.receivableAccountUpdateDate = receivableAccountUpdateDate;
    }

    public Double getReceivableAccountTotal() {
        return receivableAccountTotal;
    }

    public void setReceivableAccountTotal(Double receivableAccountTotal) {
        this.receivableAccountTotal = receivableAccountTotal;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<AccountRecord> getAccountRecordList() {
        return accountRecordList;
    }

    public void setAccountRecordList(List<AccountRecord> accountRecordList) {
        this.accountRecordList = accountRecordList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receivableAccountId != null ? receivableAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceivableAccount)) {
            return false;
        }
        ReceivableAccount other = (ReceivableAccount) object;
        if ((this.receivableAccountId == null && other.receivableAccountId != null) || (this.receivableAccountId != null && !this.receivableAccountId.equals(other.receivableAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReceivableAccount[ receivableAccountId=" + receivableAccountId + " ]";
    }

    /**
     * @return the receivableAccountCount
     */
    public Integer getReceivableAccountCount() {
        return receivableAccountCount;
    }

    /**
     * @param receivableAccountCount the receivableAccountCount to set
     */
    public void setReceivableAccountCount(Integer receivableAccountCount) {
        this.receivableAccountCount = receivableAccountCount;
    }
    
}
