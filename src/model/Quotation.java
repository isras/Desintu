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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jhoe
 */
@Entity
@Table(name = "quotation")
@NamedQueries({
    @NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q")})
public class Quotation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quotation_id")
    private Long quotationId;
    @Column(name = "qo_number")
    private String quotationNumber;
    @Column(name = "qo_date")
    @Temporal(TemporalType.DATE)
    private Date quotationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qo_subtotal")
    private Double quotationSubtotal;
    @Column(name = "qo_iva")
    private Double quotationIva;
    @Column(name = "qo_total")
    private Double quotationTotal;
    @JoinColumn(name = "qo_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person person;

    public Quotation() {
    }

    public Quotation(Long quotationId) {
        this.quotationId = quotationId;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public String getQuotationNumber() {
        return quotationNumber;
    }

    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public Date getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(Date quotationDate) {
        this.quotationDate = quotationDate;
    }

    public Double getQuotationSubtotal() {
        return quotationSubtotal;
    }

    public void setQuotationSubtotal(Double quotationSubtotal) {
        this.quotationSubtotal = quotationSubtotal;
    }

    public Double getQuotationIva() {
        return quotationIva;
    }

    public void setQuotationIva(Double quotationIva) {
        this.quotationIva = quotationIva;
    }

    public Double getQuotationTotal() {
        return quotationTotal;
    }

    public void setQuotationTotal(Double quotationTotal) {
        this.quotationTotal = quotationTotal;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quotationId != null ? quotationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quotation)) {
            return false;
        }
        Quotation other = (Quotation) object;
        if ((this.quotationId == null && other.quotationId != null) || (this.quotationId != null && !this.quotationId.equals(other.quotationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quotation[ quotationId=" + quotationId + " ]";
    }
    
}
