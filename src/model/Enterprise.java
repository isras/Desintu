/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jhoe
 */
@Entity
@Table(name = "enterprise")
@NamedQueries({
    @NamedQuery(name = "Enterprise.findAll", query = "SELECT e FROM Enterprise e")})
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enterprise_id")
    private Long enterpriseId;
    @Column(name = "enterprise_name")
    private String enterpriseName;
    @Column(name = "enterprise_ruc")
    private String enterpriseRuc;
    @Lob
    @Column(name = "enterprise_description")
    private String enterpriseDescription;
    @Column(name = "enterprise_type")
    private String enterpriseType;
    @Column(name = "enterprise_first_facture_number")
    private Integer enterpriseFirstFactureNumber;
    @Column(name = "enterprise_first_facture_number1")
    private Integer enterpriseFirstFactureNumber1;
    @Column(name = "enterprise_first_facture_number2")
    private Integer enterpriseFirstFactureNumber2;

    public Enterprise() {
    }

    public Enterprise(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseRuc() {
        return enterpriseRuc;
    }

    public void setEnterpriseRuc(String enterpriseRuc) {
        this.enterpriseRuc = enterpriseRuc;
    }

    public String getEnterpriseDescription() {
        return enterpriseDescription;
    }

    public void setEnterpriseDescription(String enterpriseDescription) {
        this.enterpriseDescription = enterpriseDescription;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Integer getEnterpriseFirstFactureNumber() {
        return enterpriseFirstFactureNumber;
    }

    public void setEnterpriseFirstFactureNumber(Integer enterpriseFirstFactureNumber) {
        this.enterpriseFirstFactureNumber = enterpriseFirstFactureNumber;
    }

    public Integer getEnterpriseFirstFactureNumber1() {
        return enterpriseFirstFactureNumber1;
    }

    public void setEnterpriseFirstFactureNumber1(Integer enterpriseFirstFactureNumber1) {
        this.enterpriseFirstFactureNumber1 = enterpriseFirstFactureNumber1;
    }

    public Integer getEnterpriseFirstFactureNumber2() {
        return enterpriseFirstFactureNumber2;
    }

    public void setEnterpriseFirstFactureNumber2(Integer enterpriseFirstFactureNumber2) {
        this.enterpriseFirstFactureNumber2 = enterpriseFirstFactureNumber2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enterpriseId != null ? enterpriseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enterprise)) {
            return false;
        }
        Enterprise other = (Enterprise) object;
        if ((this.enterpriseId == null && other.enterpriseId != null) || (this.enterpriseId != null && !this.enterpriseId.equals(other.enterpriseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Enterprise[ enterpriseId=" + enterpriseId + " ]";
    }

}
