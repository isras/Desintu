/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "closing_cash")
@NamedQueries({
    @NamedQuery(name = "ClosingCash.findAll", query = "SELECT c FROM ClosingCash c")})
public class ClosingCash implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "closing_cash_id")
    private Long closingCashId;
    @Column(name = "cc_date_from")
    @Temporal(TemporalType.DATE)
    private Date ccDateFrom;
    @Column(name = "cc_date_to")
    @Temporal(TemporalType.DATE)
    private Date ccDateTo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cc_initial_cash_value")
    private Double ccInitialCashValue;
    @Column(name = "cc_total_cash")
    private Double ccTotalCash;
    @Column(name = "cc_total_cheks")
    private Double ccTotalCheks;
    @Column(name = "cc_total_credit_card")
    private Double ccTotalCreditCard;
    @Column(name = "cc_total_debit_card")
    private Double ccTotalDebitCard;
    @Column(name = "cc_total_inflow")
    private Double ccTotalInflow;
    @Column(name = "cc_total_outflow")
    private Double ccTotalOutflow;
    @Column(name = "cc_total_receivable_accounts")
    private Double ccTotalReceivableAccounts;
    @Column(name = "cc_total")
    private Double ccTotal;
    @Column(name = "cc_observation")
    private String ccObservation;

    public ClosingCash() {
    }

    public ClosingCash(Long closingCashId) {
        this.closingCashId = closingCashId;
    }

    public Long getClosingCashId() {
        return closingCashId;
    }

    public void setClosingCashId(Long closingCashId) {
        this.closingCashId = closingCashId;
    }

    public Date getCcDateFrom() {
        return ccDateFrom;
    }

    public void setCcDateFrom(Date ccDateFrom) {
        this.ccDateFrom = ccDateFrom;
    }

    public Date getCcDateTo() {
        return ccDateTo;
    }

    public void setCcDateTo(Date ccDateTo) {
        this.ccDateTo = ccDateTo;
    }

    public Double getCcInitialCashValue() {
        return ccInitialCashValue;
    }

    public void setCcInitialCashValue(Double ccInitialCashValue) {
        this.ccInitialCashValue = ccInitialCashValue;
    }

    public Double getCcTotalCash() {
        return ccTotalCash;
    }

    public void setCcTotalCash(Double ccTotalCash) {
        this.ccTotalCash = ccTotalCash;
    }

    public Double getCcTotalCheks() {
        return ccTotalCheks;
    }

    public void setCcTotalCheks(Double ccTotalCheks) {
        this.ccTotalCheks = ccTotalCheks;
    }

    public Double getCcTotalCreditCard() {
        return ccTotalCreditCard;
    }

    public void setCcTotalCreditCard(Double ccTotalCreditCard) {
        this.ccTotalCreditCard = ccTotalCreditCard;
    }

    public Double getCcTotalDebitCard() {
        return ccTotalDebitCard;
    }

    public void setCcTotalDebitCard(Double ccTotalDebitCard) {
        this.ccTotalDebitCard = ccTotalDebitCard;
    }

    public Double getCcTotalInflow() {
        return ccTotalInflow;
    }

    public void setCcTotalInflow(Double ccTotalInflow) {
        this.ccTotalInflow = ccTotalInflow;
    }

    public Double getCcTotalOutflow() {
        return ccTotalOutflow;
    }

    public void setCcTotalOutflow(Double ccTotalOutflow) {
        this.ccTotalOutflow = ccTotalOutflow;
    }

    public Double getCcTotalReceivableAccounts() {
        return ccTotalReceivableAccounts;
    }

    public void setCcTotalReceivableAccounts(Double ccTotalReceivableAccounts) {
        this.ccTotalReceivableAccounts = ccTotalReceivableAccounts;
    }

    public Double getCcTotal() {
        return ccTotal;
    }

    public void setCcTotal(Double ccTotal) {
        this.ccTotal = ccTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (closingCashId != null ? closingCashId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClosingCash)) {
            return false;
        }
        ClosingCash other = (ClosingCash) object;
        if ((this.closingCashId == null && other.closingCashId != null) || (this.closingCashId != null && !this.closingCashId.equals(other.closingCashId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ClosingCash[ closingCashId=" + closingCashId + " ]";
    }

    /**
     * @return the ccObservation
     */
    public String getCcObservation() {
        return ccObservation;
    }

    /**
     * @param ccObservation the ccObservation to set
     */
    public void setCcObservation(String ccObservation) {
        this.ccObservation = ccObservation;
    }
    
}
