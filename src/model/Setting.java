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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "setting")
@NamedQueries({
    @NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s")})
public class Setting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "setting_id")
    private Long settingId;
    @Column(name = "pr_first_invoice_number")
    private String FIRST_INVOICE_NUMBER;
    @Column(name = "pr_second_invoice_number")
    private String SECOND_INVOICE_NUMBER;
    @Column(name = "pr_third_invoice_number")
    private String THIRD_INVOICE_NUMBER;
    @Column (name = "pr_quotation_number")
    private Integer QUOTATION_NUMBER;
    @Column (name = "pr_work_order_number")
    private Integer WORK_ORDER_NUMBER;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pr_iva_value")
    private Double IVA_VALUE;
    @Column(name = "pr_accuracy_value")
    private Integer ACCURACY_VALUE;
    @Column(name = "pr_authorization_number")
    private String AUTHORIZATION_NUMBER;
    @Column(name = "pr_show_print_preview")
    private Boolean SHOW_PRINT_PREVIEW;
    @Column(name = "pr_simple_service_value")
    private Integer SIMPLE_SERVICE_VALUE;
    @Column(name = "pr_medium_service_value")
    private Integer MEDIUM_SERVICE_VALUE;
    @Column(name = "pr_complex_service_value")
    private Integer COMPLEX_SERVICE_VALUE;
    @Column (name = "pr_publicist_print_discount_value")
    private Integer PUBLICIST_PRINT_DISCOUNT_VALUE;
    @Column (name = "pr_publicist_finished_discount_value")
    private Integer PUBLICIST_FINISHED_DISCOUNT_VALUE;
    @Column (name = "pr_publicist_service_discount_value")
    private Integer PUBLICIST_SERVICE_DISCOUNT_VALUE;
    @Column (name = "pr_personal_insurance_contribution")
    private Double PERSONAL_INSURANCE_CONTRIBUTION;
    @Column (name = "pr_basic_salary")
    private Double BASIC_SALARY;

    public Setting() {
    }

    public Setting(Long preferencesId) {
        this.settingId = preferencesId;
    }

    public Long getSettingId() {
        return settingId;
    }

    public void setSettingId(Long settingId) {
        this.settingId = settingId;
    }

    public String getFIRST_INVOICE_NUMBER() {
        return FIRST_INVOICE_NUMBER;
    }

    public void setFIRST_INVOICE_NUMBER(String FIRST_INVOICE_NUMBER) {
        this.FIRST_INVOICE_NUMBER = FIRST_INVOICE_NUMBER;
    }

    public Double getIVA_VALUE() {
        return IVA_VALUE;
    }

    public void setIVA_VALUE(Double IVA_VALUE) {
        this.IVA_VALUE = IVA_VALUE;
    }

    public String getSECOND_INVOICE_NUMBER() {
        return SECOND_INVOICE_NUMBER;
    }

    public void setSECOND_INVOICE_NUMBER(String SECOND_INVOICE_NUMBER) {
        this.SECOND_INVOICE_NUMBER = SECOND_INVOICE_NUMBER;
    }

    public String getTHIRD_INVOICE_NUMBER() {
        return THIRD_INVOICE_NUMBER;
    }

    public void setTHIRD_INVOICE_NUMBER(String THIRD_INVOICE_NUMBER) {
        this.THIRD_INVOICE_NUMBER = THIRD_INVOICE_NUMBER;
    }

    public Integer getACCURACY_VALUE() {
        return ACCURACY_VALUE;
    }

    public void setACCURACY_VALUE(Integer ACCURACY_VALUE) {
        this.ACCURACY_VALUE = ACCURACY_VALUE;
    }

    public String getAUTHORIZATION_NUMBER() {
        return AUTHORIZATION_NUMBER;
    }

    public void setAUTHORIZATION_NUMBER(String AUTHORIZATION_NUMBER) {
        this.AUTHORIZATION_NUMBER = AUTHORIZATION_NUMBER;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (settingId != null ? settingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setting)) {
            return false;
        }
        Setting other = (Setting) object;
        if ((this.settingId == null && other.settingId != null) || (this.settingId != null && !this.settingId.equals(other.settingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Setting[ preferencesId=" + settingId + " ]";
    }

    /**
     * @return the SHOW_PRINT_PREVIEW
     */
    public Boolean getSHOW_PRINT_PREVIEW() {
        return SHOW_PRINT_PREVIEW;
    }

    /**
     * @param SHOW_PRINT_PREVIEW the SHOW_PRINT_PREVIEW to set
     */
    public void setSHOW_PRINT_PREVIEW(Boolean SHOW_PRINT_PREVIEW) {
        this.SHOW_PRINT_PREVIEW = SHOW_PRINT_PREVIEW;
    }

    /**
     * @return the SIMPLE_SERVICE_VALUE
     */
    public Integer getSIMPLE_SERVICE_VALUE() {
        return SIMPLE_SERVICE_VALUE;
    }

    /**
     * @param SIMPLE_SERVICE_VALUE the SIMPLE_SERVICE_VALUE to set
     */
    public void setSIMPLE_SERVICE_VALUE(Integer SIMPLE_SERVICE_VALUE) {
        this.SIMPLE_SERVICE_VALUE = SIMPLE_SERVICE_VALUE;
    }

    /**
     * @return the MEDIUM_SERVICE_VALUE
     */
    public Integer getMEDIUM_SERVICE_VALUE() {
        return MEDIUM_SERVICE_VALUE;
    }

    /**
     * @param MEDIUM_SERVICE_VALUE the MEDIUM_SERVICE_VALUE to set
     */
    public void setMEDIUM_SERVICE_VALUE(Integer MEDIUM_SERVICE_VALUE) {
        this.MEDIUM_SERVICE_VALUE = MEDIUM_SERVICE_VALUE;
    }

    /**
     * @return the COMPLEX_SERVICE_VALUE
     */
    public Integer getCOMPLEX_SERVICE_VALUE() {
        return COMPLEX_SERVICE_VALUE;
    }

    /**
     * @param COMPLEX_SERVICE_VALUE the COMPLEX_SERVICE_VALUE to set
     */
    public void setCOMPLEX_SERVICE_VALUE(Integer COMPLEX_SERVICE_VALUE) {
        this.COMPLEX_SERVICE_VALUE = COMPLEX_SERVICE_VALUE;
    }

    /**
     * @return the PUBLICIST_PRINT_DISCOUNT_VALUE
     */
    public Integer getPUBLICIST_PRINT_DISCOUNT_VALUE() {
        return PUBLICIST_PRINT_DISCOUNT_VALUE;
    }

    /**
     * @param PUBLICIST_PRINT_DISCOUNT_VALUE the PUBLICIST_PRINT_DISCOUNT_VALUE to set
     */
    public void setPUBLICIST_PRINT_DISCOUNT_VALUE(Integer PUBLICIST_PRINT_DISCOUNT_VALUE) {
        this.PUBLICIST_PRINT_DISCOUNT_VALUE = PUBLICIST_PRINT_DISCOUNT_VALUE;
    }

    /**
     * @return the PUBLICIST_FINISHED_DISCOUNT_VALUE
     */
    public Integer getPUBLICIST_FINISHED_DISCOUNT_VALUE() {
        return PUBLICIST_FINISHED_DISCOUNT_VALUE;
    }

    /**
     * @param PUBLICIST_FINISHED_DISCOUNT_VALUE the PUBLICIST_FINISHED_DISCOUNT_VALUE to set
     */
    public void setPUBLICIST_FINISHED_DISCOUNT_VALUE(Integer PUBLICIST_FINISHED_DISCOUNT_VALUE) {
        this.PUBLICIST_FINISHED_DISCOUNT_VALUE = PUBLICIST_FINISHED_DISCOUNT_VALUE;
    }

    /**
     * @return the PUBLICIST_SERVICE_DISCOUNT_VALUE
     */
    public Integer getPUBLICIST_SERVICE_DISCOUNT_VALUE() {
        return PUBLICIST_SERVICE_DISCOUNT_VALUE;
    }

    /**
     * @param PUBLICIST_SERVICE_DISCOUNT_VALUE the PUBLICIST_SERVICE_DISCOUNT_VALUE to set
     */
    public void setPUBLICIST_SERVICE_DISCOUNT_VALUE(Integer PUBLICIST_SERVICE_DISCOUNT_VALUE) {
        this.PUBLICIST_SERVICE_DISCOUNT_VALUE = PUBLICIST_SERVICE_DISCOUNT_VALUE;
    }

    /**
     * @return the QUOTATION_NUMBER
     */
    public Integer getQUOTATION_NUMBER() {
        return QUOTATION_NUMBER;
    }

    /**
     * @param QUOTATION_NUMBER the QUOTATION_NUMBER to set
     */
    public void setQUOTATION_NUMBER(Integer QUOTATION_NUMBER) {
        this.QUOTATION_NUMBER = QUOTATION_NUMBER;
    }

    /**
     * @return the WORK_ORDER_NUMBER
     */
    public Integer getWORK_ORDER_NUMBER() {
        return WORK_ORDER_NUMBER;
    }

    /**
     * @param WORK_ORDER_NUMBER the WORK_ORDER_NUMBER to set
     */
    public void setWORK_ORDER_NUMBER(Integer WORK_ORDER_NUMBER) {
        this.WORK_ORDER_NUMBER = WORK_ORDER_NUMBER;
    }   

    /**
     * @return the PERSONAL_INSURANCE_CONTRIBUTION
     */
    public Double getPERSONAL_INSURANCE_CONTRIBUTION() {
        return PERSONAL_INSURANCE_CONTRIBUTION;
    }

    /**
     * @param PERSONAL_INSURANCE_CONTRIBUTION the PERSONAL_INSURANCE_CONTRIBUTION to set
     */
    public void setPERSONAL_INSURANCE_CONTRIBUTION(Double PERSONAL_INSURANCE_CONTRIBUTION) {
        this.PERSONAL_INSURANCE_CONTRIBUTION = PERSONAL_INSURANCE_CONTRIBUTION;
    }

    /**
     * @return the BASIC_SALARY
     */
    public Double getBASIC_SALARY() {
        return BASIC_SALARY;
    }

    /**
     * @param BASIC_SALARY the BASIC_SALARY to set
     */
    public void setBASIC_SALARY(Double BASIC_SALARY) {
        this.BASIC_SALARY = BASIC_SALARY;
    }
}