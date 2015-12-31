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
import javax.persistence.Basic;
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
 * @author Jhoe
 */
@Entity
@Table(name = "sellnote")
@NamedQueries({
    @NamedQuery(name = "Sellnote.findAll", query = "SELECT s FROM Sellnote s")})
public class Sellnote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sell_note_id")
    private Long sellNoteId;
    @Column(name = "sn_type")
    private String snType;
    @Column(name = "sn_issue_date")
    @Temporal(TemporalType.DATE)
    private Date snIssueDate;
    @Column(name = "sn_payment_method")
    private Integer snPaymentMethod;
    @Column(name = "sn_number")
    private String snNumber;
    @Column(name = "sn_state")
    private String snState;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sn_total")
    private Double snTotal;
    @Column(name = "sn_advance")
    private Double snAdvance;
    @Column(name = "sn_balance")
    private Double snBalance;
    @JoinColumn(name = "person_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person person;
    @OneToMany(mappedBy = "sellnote")
    private List<Detail> detailList;

    public Sellnote() {
        detailList = new ArrayList<>();
    }

    public Sellnote(Long sellNoteId) {
        this.sellNoteId = sellNoteId;
    }

    public Long getSellNoteId() {
        return sellNoteId;
    }

    public void setSellNoteId(Long sellNoteId) {
        this.sellNoteId = sellNoteId;
    }

    public String getSnType() {
        return snType;
    }

    public void setSnType(String snType) {
        this.snType = snType;
    }

    public Date getSnIssueDate() {
        return snIssueDate;
    }

    public void setSnIssueDate(Date snIssueDate) {
        this.snIssueDate = snIssueDate;
    }

    public Integer getSnPaymentMethod() {
        return snPaymentMethod;
    }

    public void setSnPaymentMethod(Integer snPaymentMethod) {
        this.snPaymentMethod = snPaymentMethod;
    }

    public String getSnNumber() {
        return snNumber;
    }

    public void setSnNumber(String snNumber) {
        this.snNumber = snNumber;
    }

    public String getSnState() {
        return snState;
    }

    public void setSnState(String snState) {
        this.snState = snState;
    }

    public Double getSnTotal() {
        return snTotal;
    }

    public void setSnTotal(Double snTotal) {
        this.snTotal = snTotal;
    }

    public Double getSnAdvance() {
        return snAdvance;
    }

    public void setSnAdvance(Double snAdvance) {
        this.snAdvance = snAdvance;
    }

    public Double getSnBalance() {
        return snBalance;
    }

    public void setSnBalance(Double snBalance) {
        this.snBalance = snBalance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellNoteId != null ? sellNoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sellnote)) {
            return false;
        }
        Sellnote other = (Sellnote) object;
        if ((this.sellNoteId == null && other.sellNoteId != null) || (this.sellNoteId != null && !this.sellNoteId.equals(other.sellNoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sellnote[ sellNoteId=" + sellNoteId + " ]";
    }
    
}
