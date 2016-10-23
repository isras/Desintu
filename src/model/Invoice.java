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

@Entity
@Table(name = "invoice")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")})
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id")
    private Long invoiceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "in_subtotal")
    private Double inSubtotal;
    @Column(name = "in_subtotal_ivazero")
    private Double inSubtotalIvazero;
    @Column(name = "in_subtotal_iva")
    private Double inSubtotalIva;
    @Column(name = "in_iva")
    private Double inIva;
    @Column(name = "in_total")
    private Double inTotal;
    @Column(name = "in_change")
    private Double inChange;
    @Column(name = "in_cash")
    private Double inCash;
    @Column(name = "in_authorization_date")
    @Temporal(TemporalType.DATE)
    private Date inAuthorizationDate;
    @Column(name = "in_issue_time")
    @Temporal(TemporalType.TIME)
    private Date inIssueTime;
    @Column(name = "in_number")
    private String inNumber;
    @Column(name = "in_discount")
    private Double inDiscount;
    @Column(name = "in_issue_date")
    @Temporal(TemporalType.DATE)
    private Date inIssueDate;
    @Column(name = "in_state")
    private String inState;
    @Column (name = "invoice_count")
    private Integer invoiceCount;
    @Column(name = "in_petition_name")
    private String inPetitionName;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST)
    private List<Detail> detailList;
    @JoinColumn(name = "person_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person person;

    public Invoice() {
        detailList = new ArrayList<>();
    }

    public Invoice(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getInSubtotal() {
        return inSubtotal;
    }

    public void setInSubtotal(Double inSubtotal) {
        this.inSubtotal = inSubtotal;
    }

    public Double getInIva() {
        return inIva;
    }

    public void setInIva(Double inIva) {
        this.inIva = inIva;
    }

    public Double getInTotal() {
        return inTotal;
    }

    public void setInTotal(Double inTotal) {
        this.inTotal = inTotal;
    }

    public Double getInChange() {
        return inChange;
    }

    public void setInChange(Double inChange) {
        this.inChange = inChange;
    }

    public Double getInCash() {
        return inCash;
    }

    public void setInCash(Double inCash) {
        this.inCash = inCash;
    }

    public Date getInAuthorizationDate() {
        return inAuthorizationDate;
    }

    public void setInAuthorizationDate(Date inAuthorizationDate) {
        this.inAuthorizationDate = inAuthorizationDate;
    }

    public Date getInIssueTime() {
        return inIssueTime;
    }

    public void setInIssueTime(Date inIssueTime) {
        this.inIssueTime = inIssueTime;
    }

    public String getInNumber() {
        return inNumber;
    }

    public void setInNumber(String inNumber) {
        this.inNumber = inNumber;
    }

    public Double getInDiscount() {
        return inDiscount;
    }

    public void setInDiscount(Double inDiscount) {
        this.inDiscount = inDiscount;
    }

    public Date getInIssueDate() {
        return inIssueDate;
    }

    public void setInIssueDate(Date inIssueDate) {
        this.inIssueDate = inIssueDate;
    }

    public String getInState() {
        return inState;
    }

    public void setInState(String inState) {
        this.inState = inState;
    }

    public String getInPetitionName() {
        return inPetitionName;
    }

    public void setInPetitionName(String inPetitionName) {
        this.inPetitionName = inPetitionName;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
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
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Invoice[ invoiceId=" + invoiceId + " ]";
    }

    /**
     * @return the inSubtotalIva
     */
    public Double getInSubtotalIva() {
        return inSubtotalIva;
    }

    /**
     * @param inSubtotalIva the inSubtotalIva to set
     */
    public void setInSubtotalIva(Double inSubtotalIva) {
        this.inSubtotalIva = inSubtotalIva;
    }

    /**
     * @return the inSubtotalIvazero
     */
    public Double getInSubtotalIvazero() {
        return inSubtotalIvazero;
    }

    /**
     * @param inSubtotalIvazero the inSubtotalIvazero to set
     */
    public void setInSubtotalIvazero(Double inSubtotalIvazero) {
        this.inSubtotalIvazero = inSubtotalIvazero;
    }

    /**
     * @return the invoiceCount
     */
    public Integer getInvoiceCount() {
        return invoiceCount;
    }

    /**
     * @param invoiceCount the invoiceCount to set
     */
    public void setInvoiceCount(Integer invoiceCount) {
        this.invoiceCount = invoiceCount;
    }
    
}
