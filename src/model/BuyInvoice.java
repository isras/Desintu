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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "buy_invoice")
public class BuyInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buy_invoice_id")
    private Long buyInvoiceId;
    @Column(name = "bin_number")
    private String buyInvoiceNumber;
    @Column(name = "bin_reference")
    private String buyInvoiceReference;
    @Column(name = "bin_date")
    @Temporal(TemporalType.DATE)
    private Date buyInvoiceDate;
    @Column(name = "bin_description")
    private String buyInvoiceDescription;
    @Column(name = "bin_total")
    private Double buyInvoiceTotal;
    @JoinColumn(name = "bin_supplier_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person supplier;

    public BuyInvoice() {

    }

    /**
     * @return the buyInvoiceId
     */
    public Long getBuyInvoiceId() {
        return buyInvoiceId;
    }

    /**
     * @param buyInvoiceId the buyInvoiceId to set
     */
    public void setBuyInvoiceId(Long buyInvoiceId) {
        this.buyInvoiceId = buyInvoiceId;
    }

    /**
     * @return the buyInvoiceNumber
     */
    public String getBuyInvoiceNumber() {
        return buyInvoiceNumber;
    }

    /**
     * @param buyInvoiceNumber the buyInvoiceNumber to set
     */
    public void setBuyInvoiceNumber(String buyInvoiceNumber) {
        this.buyInvoiceNumber = buyInvoiceNumber;
    }

    /**
     * @return the buyInvoiceReference
     */
    public String getBuyInvoiceReference() {
        return buyInvoiceReference;
    }

    /**
     * @param buyInvoiceReference the buyInvoiceReference to set
     */
    public void setBuyInvoiceReference(String buyInvoiceReference) {
        this.buyInvoiceReference = buyInvoiceReference;
    }

    /**
     * @return the buyInvoiceDate
     */
    public Date getBuyInvoiceDate() {
        return buyInvoiceDate;
    }

    /**
     * @param buyInvoiceDate the buyInvoiceDate to set
     */
    public void setBuyInvoiceDate(Date buyInvoiceDate) {
        this.buyInvoiceDate = buyInvoiceDate;
    }

    /**
     * @return the buyInvoiceDescription
     */
    public String getBuyInvoiceDescription() {
        return buyInvoiceDescription;
    }

    /**
     * @param buyInvoiceDescription the buyInvoiceDescription to set
     */
    public void setBuyInvoiceDescription(String buyInvoiceDescription) {
        this.buyInvoiceDescription = buyInvoiceDescription;
    }

    /**
     * @return the buyInvoiceTotal
     */
    public Double getBuyInvoiceTotal() {
        return buyInvoiceTotal;
    }

    /**
     * @param buyInvoiceTotal the buyInvoiceTotal to set
     */
    public void setBuyInvoiceTotal(Double buyInvoiceTotal) {
        this.buyInvoiceTotal = buyInvoiceTotal;
    }

    /**
     * @return the supplier
     */
    public Person getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Person supplier) {
        this.supplier = supplier;
    }
}