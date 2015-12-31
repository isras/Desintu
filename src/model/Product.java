/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jhoe
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "pd_description")
    private String pdDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pd_sale_price")
    private Double pdSalePrice;
    @Column(name = "pd_name")
    private String pdName;
    @Column(name = "pd_code")
    private String pdCode;
    @Column(name = "pd_barcode")
    private String pdBarcode;
    @Column(name = "pd_iva_state")
    private Integer pdIvaState;
    @Column(name = "pd_stock")
    private Double pdStock;
    @Column(name = "pd_type")
    private String pdType;
    @OneToMany(mappedBy = "product")
    private List<Detail> detailList;

    public Product() {
        detailList = new ArrayList<>();
    }

    public Product(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPdDescription() {
        return pdDescription;
    }

    public void setPdDescription(String pdDescription) {
        this.pdDescription = pdDescription;
    }

    public Double getPdSalePrice() {
        return pdSalePrice;
    }

    public void setPdSalePrice(Double pdSalePrice) {
        this.pdSalePrice = pdSalePrice;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdBarcode() {
        return pdBarcode;
    }

    public void setPdBarcode(String pdBarcode) {
        this.pdBarcode = pdBarcode;
    }

    public Integer getPdIvaState() {
        return pdIvaState;
    }

    public void setPdIvaState(Integer pdIvaState) {
        this.pdIvaState = pdIvaState;
    }

    public Double getPdStock() {
        return pdStock;
    }

    public void setPdStock(Double pdStock) {
        this.pdStock = pdStock;
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
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pdName;
    }

    /**
     * @return the pdType
     */
    public String getPdType() {
        return pdType;
    }

    /**
     * @param pdType the pdType to set
     */
    public void setPdType(String pdType) {
        this.pdType = pdType;
    }
    
}
