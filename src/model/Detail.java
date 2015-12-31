/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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

/**
 *
 * @author Jhoe
 */
@Entity
@Table(name = "detail")
@NamedQueries({
    @NamedQuery(name = "Detail.findAll", query = "SELECT d FROM Detail d")})
public class Detail implements Serializable {

    @JoinColumn(name = "work_order_work_order_id", referencedColumnName = "work_order_id")
    @ManyToOne
    private WorkOrder workOrderWorkOrderId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detail_id")
    private Long detailId;
    @Column(name = "det_type")
    private String detType;
    @Column(name = "det_description")
    private String detDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "det_sale_price")
    private Double detSalePrice;
    @Column(name = "det_quantity")
    private Double detQuantity;
    @Column(name = "det_total")
    private Double detTotal;
    @JoinColumn(name = "invoice_invoice_id", referencedColumnName = "invoice_id")
    @ManyToOne
    private Invoice invoice;
    @JoinColumn(name = "petition_petition_id", referencedColumnName = "petition_id")
    @ManyToOne
    private Petition petition;
    @JoinColumn(name = "product_product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "sellnote_sell_note_id", referencedColumnName = "sell_note_id")
    @ManyToOne
    private Sellnote sellnote;

    public Detail() {
    }

    public Detail(Long detailId) {
        this.detailId = detailId;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getDetType() {
        return detType;
    }

    public void setDetType(String detType) {
        this.detType = detType;
    }

    public String getDetDescription() {
        return detDescription;
    }

    public void setDetDescription(String detDescription) {
        this.detDescription = detDescription;
    }

    public Double getDetSalePrice() {
        return detSalePrice;
    }

    public void setDetSalePrice(Double detSalePrice) {
        this.detSalePrice = detSalePrice;
    }

    public Double getDetQuantity() {
        return detQuantity;
    }

    public void setDetQuantity(Double detQuantity) {
        this.detQuantity = detQuantity;
    }

    public Double getDetTotal() {
        return detTotal;
    }

    public void setDetTotal(Double detTotal) {
        this.detTotal = detTotal;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Petition getPetition() {
        return petition;
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sellnote getSellnote() {
        return sellnote;
    }

    public void setSellnote(Sellnote sellnote) {
        this.sellnote = sellnote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailId != null ? detailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detail)) {
            return false;
        }
        Detail other = (Detail) object;
        if ((this.detailId == null && other.detailId != null) || (this.detailId != null && !this.detailId.equals(other.detailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Detail[ detailId=" + detailId + " ]";
    }

    public WorkOrder getWorkOrderWorkOrderId() {
        return workOrderWorkOrderId;
    }

    public void setWorkOrderWorkOrderId(WorkOrder workOrderWorkOrderId) {
        this.workOrderWorkOrderId = workOrderWorkOrderId;
    }

}
