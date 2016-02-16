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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eyetive
 */
@Entity
@Table(name = "work_order")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "WorkOrder.findAll", query = "SELECT w FROM WorkOrder w"),
//    @NamedQuery(name = "WorkOrder.findByWorkOrderId", query = "SELECT w FROM WorkOrder w WHERE w.workOrderId = :workOrderId"),
//    @NamedQuery(name = "WorkOrder.findByWoState", query = "SELECT w FROM WorkOrder w WHERE w.workOrderState = :workOrderState"),
//    @NamedQuery(name = "WorkOrder.findByWoDescription", query = "SELECT w FROM WorkOrder w WHERE w.workOrderDescription = :workOrderDescription"),
//    @NamedQuery(name = "WorkOrder.findByWoNumber", query = "SELECT w FROM WorkOrder w WHERE w.workOrderNumber = :workOrderNumber"),
//    @NamedQuery(name = "WorkOrder.findByWoIssueDate", query = "SELECT w FROM WorkOrder w WHERE w.workOrderIssueDate = :workOrderIssueDate"),
//    @NamedQuery(name = "WorkOrder.findByWoDeliveryDate", query = "SELECT w FROM WorkOrder w WHERE w.workOrderDeliveryDate = :workOrderDeliveryDate"),
//    @NamedQuery(name = "WorkOrder.findByWoTotal", query = "SELECT w FROM WorkOrder w WHERE w.workOrderTotal = :workOrderTotal"),
//    @NamedQuery(name = "WorkOrder.findByWoBalance", query = "SELECT w FROM WorkOrder w WHERE w.workOrderBalance = :workOrderBalance"),
//    @NamedQuery(name = "WorkOrder.findByWoAdvance", query = "SELECT w FROM WorkOrder w WHERE w.workOrderAdvance = :workOrderAdvance")})
public class WorkOrder implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "work_order_id")
    private Long workOrderId;
    @Column(name = "wo_state")
    private Integer workOrderState;
    @Column(name = "wo_priority")
    private Integer workOrderPriority;
    @Column(name = "wo_description")
    private String workOrderDescription;
    @Column(name = "wo_number")
    private String workOrderNumber;
    @Column(name = "wo_issue_date")
    @Temporal(TemporalType.DATE)
    private Date workOrderIssueDate;
    @Column(name = "wo_delivery_date")
    @Temporal(TemporalType.DATE)
    private Date workOrderDeliveryDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "wo_total")
    private Double workOrderTotal;
    @Column(name = "wo_balance")
    private Double workOrderBalance;
    @Column(name = "wo_advance")
    private Double workOrderAdvance;
    
    //Esta parte es temporal
    @Column (name = "wo_type")
    private String workOrderType;
    @Column (name = "wo_invoice_state")
    private String workOrderInvoiceState;
    @Column (name = "wo_subtotal")
    private Double workOrderSubtotal;
    @Column (name = "wo_iva")
    private Double workOrderIva;
    @Column (name = "wo_invoice_total")
    private Double workOrderInvoiceTotal;
    
    @Column (name = "wo_cash")
    private Double workOrderCash;
    @Column (name = "wo_change")
    private Double workOrderChange;
    
    
    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.PERSIST)
    private List<Detail> detailList;
    @JoinColumn(name = "person_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "wo_employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employee employee;

    public WorkOrder() {
        this.detailList = new ArrayList<>();
    }

    public WorkOrder(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Integer getWorkOrderState() {
        return workOrderState;
    }

    public void setWorkOrderState(Integer workOrderState) {
        this.workOrderState = workOrderState;
    }

    public String getWorkOrderDescription() {
        return workOrderDescription;
    }

    public void setWorkOrderDescription(String workOrderDescription) {
        this.workOrderDescription = workOrderDescription;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Date getWorkOrderIssueDate() {
        return workOrderIssueDate;
    }

    public void setWorkOrderIssueDate(Date workOrderIssueDate) {
        this.workOrderIssueDate = workOrderIssueDate;
    }

    public Date getWorkOrderDeliveryDate() {
        return workOrderDeliveryDate;
    }

    public void setWorkOrderDeliveryDate(Date workOrderDeliveryDate) {
        this.workOrderDeliveryDate = workOrderDeliveryDate;
    }

    public Double getWorkOrderTotal() {
        return workOrderTotal;
    }

    public void setWorkOrderTotal(Double workOrderTotal) {
        this.workOrderTotal = workOrderTotal;
    }

    public Double getWorkOrderBalance() {
        return workOrderBalance;
    }

    public void setWorkOrderBalance(Double workOrderBalance) {
        this.workOrderBalance = workOrderBalance;
    }

    public Double getWorkOrderAdvance() {
        return workOrderAdvance;
    }

    public void setWorkOrderAdvance(Double workOrderAdvance) {
        this.workOrderAdvance = workOrderAdvance;
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
        hash += (workOrderId != null ? workOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkOrder)) {
            return false;
        }
        WorkOrder other = (WorkOrder) object;
        if ((this.workOrderId == null && other.workOrderId != null) || (this.workOrderId != null && !this.workOrderId.equals(other.workOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.WorkOrder[ workOrderId=" + workOrderId + " ]";
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the workOrderPriority
     */
    public Integer getWorkOrderPriority() {
        return workOrderPriority;
    }

    /**
     * @param workOrderPriority the workOrderPriority to set
     */
    public void setWorkOrderPriority(Integer workOrderPriority) {
        this.workOrderPriority = workOrderPriority;
    }

    /**
     * @return the workOrderType
     */
    public String getWorkOrderType() {
        return workOrderType;
    }

    /**
     * @param workOrderType the workOrderType to set
     */
    public void setWorkOrderType(String workOrderType) {
        this.workOrderType = workOrderType;
    }

    /**
     * @return the workOrderInvoiceState
     */
    public String getWorkOrderInvoiceState() {
        return workOrderInvoiceState;
    }

    /**
     * @param workOrderInvoiceState the workOrderInvoiceState to set
     */
    public void setWorkOrderInvoiceState(String workOrderInvoiceState) {
        this.workOrderInvoiceState = workOrderInvoiceState;
    }

    /**
     * @return the workOrderSubtotal
     */
    public Double getWorkOrderSubtotal() {
        return workOrderSubtotal;
    }

    /**
     * @param workOrderSubtotal the workOrderSubtotal to set
     */
    public void setWorkOrderSubtotal(Double workOrderSubtotal) {
        this.workOrderSubtotal = workOrderSubtotal;
    }

    /**
     * @return the workOrderIva
     */
    public Double getWorkOrderIva() {
        return workOrderIva;
    }

    /**
     * @param workOrderIva the workOrderIva to set
     */
    public void setWorkOrderIva(Double workOrderIva) {
        this.workOrderIva = workOrderIva;
    }

    /**
     * @return the workOrderInvoiceTotal
     */
    public Double getWorkOrderInvoiceTotal() {
        return workOrderInvoiceTotal;
    }

    /**
     * @param workOrderInvoiceTotal the workOrderInvoiceTotal to set
     */
    public void setWorkOrderInvoiceTotal(Double workOrderInvoiceTotal) {
        this.workOrderInvoiceTotal = workOrderInvoiceTotal;
    }

    /**
     * @return the workOrderCash
     */
    public Double getWorkOrderCash() {
        return workOrderCash;
    }

    /**
     * @param workOrderCash the workOrderCash to set
     */
    public void setWorkOrderCash(Double workOrderCash) {
        this.workOrderCash = workOrderCash;
    }

    /**
     * @return the workOrderChange
     */
    public Double getWorkOrderChange() {
        return workOrderChange;
    }

    /**
     * @param workOrderChange the workOrderChange to set
     */
    public void setWorkOrderChange(Double workOrderChange) {
        this.workOrderChange = workOrderChange;
    }
    
}
