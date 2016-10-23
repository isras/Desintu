package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "accounting_entry")
@NamedQueries({
    @NamedQuery(name = "AccountingEntry.findAll", query = "SELECT a FROM AccountingEntry a")})
public class AccountingEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accounting_entry_id")
    private Long accountingEntryId;
    @Column(name = "ae_type")
    private Integer aeType;
    @Column(name = "ae_created_date")
    @Temporal(TemporalType.DATE)
    private Date aeCreatedDate;
    @Lob
    @Column(name = "ae_description")
    private String aeDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ae_value")
    private Double aeValue;    

    public AccountingEntry() {
    }

    public AccountingEntry(Long accountingEntryId) {
        this.accountingEntryId = accountingEntryId;
    }

    public Long getAccountingEntryId() {
        return accountingEntryId;
    }

    public void setAccountingEntryId(Long accountingEntryId) {
        this.accountingEntryId = accountingEntryId;
    }

    public Integer getAeType() {
        return aeType;
    }

    public void setAeType(Integer aeType) {
        this.aeType = aeType;
    }

    public Date getAeCreatedDate() {
        return aeCreatedDate;
    }

    public void setAeCreatedDate(Date aeCreatedDate) {
        this.aeCreatedDate = aeCreatedDate;
    }

    public String getAeDescription() {
        return aeDescription;
    }

    public void setAeDescription(String aeDescription) {
        this.aeDescription = aeDescription;
    }

    public Double getAeValue() {
        return aeValue;
    }

    public void setAeValue(Double aeValue) {
        this.aeValue = aeValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountingEntryId != null ? accountingEntryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountingEntry)) {
            return false;
        }
        AccountingEntry other = (AccountingEntry) object;
        if ((this.accountingEntryId == null && other.accountingEntryId != null) || (this.accountingEntryId != null && !this.accountingEntryId.equals(other.accountingEntryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AccountingEntry[ accountingEntryId=" + accountingEntryId + " ]";
    }
}