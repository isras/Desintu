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
 * @author Eyetive Central
 */
@Entity
@Table(name = "account_record")
@NamedQueries({
    @NamedQuery(name = "AccountRecord.findAll", query = "SELECT a FROM AccountRecord a")})
public class AccountRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_record_id")
    private Long accountRecordId;
    @Column(name = "ar_type")
    private Integer accountRecordType;
    @Column(name = "ar_date")
    @Temporal(TemporalType.DATE)
    private Date accountRecordDate;
    @Column(name = "ar_description")
    private String accountRecordDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ar_value")
    private Double accountRecordValue;
    @JoinColumn(name = "ra_receivable_account_id", referencedColumnName = "receivable_account_id")
    @ManyToOne(optional = false)
    private ReceivableAccount receivableAccount;

    public AccountRecord() {
    }

    public AccountRecord(Long accountRecordId) {
        this.accountRecordId = accountRecordId;
    }

    public Long getAccountRecordId() {
        return accountRecordId;
    }

    public void setAccountRecordId(Long accountRecordId) {
        this.accountRecordId = accountRecordId;
    }

    public Integer getAccountRecordType() {
        return accountRecordType;
    }

    public void setAccountRecordType(Integer accountRecordType) {
        this.accountRecordType = accountRecordType;
    }

    public Date getAccountRecordDate() {
        return accountRecordDate;
    }

    public void setAccountRecordDate(Date accountRecordDate) {
        this.accountRecordDate = accountRecordDate;
    }

    public String getAccountRecordDescription() {
        return accountRecordDescription;
    }

    public void setAccountRecordDescription(String accountRecordDescription) {
        this.accountRecordDescription = accountRecordDescription;
    }

    public Double getAccountRecordValue() {
        return accountRecordValue;
    }

    public void setAccountRecordValue(Double accountRecordValue) {
        this.accountRecordValue = accountRecordValue;
    }

    public ReceivableAccount getReceivableAccount() {
        return receivableAccount;
    }

    public void setReceivableAccount(ReceivableAccount receivableAccount) {
        this.receivableAccount = receivableAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountRecordId != null ? accountRecordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountRecord)) {
            return false;
        }
        AccountRecord other = (AccountRecord) object;
        if ((this.accountRecordId == null && other.accountRecordId != null) || (this.accountRecordId != null && !this.accountRecordId.equals(other.accountRecordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AccountRecord[ accountRecordId=" + accountRecordId + " ]";
    }
    
}
