/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
//    @NamedQuery(name = "WorkOrder.findByWoState", query = "SELECT w FROM WorkOrder w WHERE w.woState = :woState"),
//    @NamedQuery(name = "WorkOrder.findByWoDescription", query = "SELECT w FROM WorkOrder w WHERE w.woDescription = :woDescription"),
//    @NamedQuery(name = "WorkOrder.findByWoNumber", query = "SELECT w FROM WorkOrder w WHERE w.woNumber = :woNumber"),
//    @NamedQuery(name = "WorkOrder.findByWoIssueDate", query = "SELECT w FROM WorkOrder w WHERE w.woIssueDate = :woIssueDate"),
//    @NamedQuery(name = "WorkOrder.findByWoDeliveryDate", query = "SELECT w FROM WorkOrder w WHERE w.woDeliveryDate = :woDeliveryDate"),
//    @NamedQuery(name = "WorkOrder.findByWoTotal", query = "SELECT w FROM WorkOrder w WHERE w.woTotal = :woTotal"),
//    @NamedQuery(name = "WorkOrder.findByWoBalance", query = "SELECT w FROM WorkOrder w WHERE w.woBalance = :woBalance"),
//    @NamedQuery(name = "WorkOrder.findByWoAdvance", query = "SELECT w FROM WorkOrder w WHERE w.woAdvance = :woAdvance")})
public class WorkOrder implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "work_order_id")
    private Long workOrderId;
    @Column(name = "wo_state")
    private Integer woState;
    @Column(name = "wo_description")
    private String woDescription;
    @Column(name = "wo_number")
    private String woNumber;
    @Column(name = "wo_issue_date")
    @Temporal(TemporalType.DATE)
    private Date woIssueDate;
    @Column(name = "wo_delivery_date")
    @Temporal(TemporalType.DATE)
    private Date woDeliveryDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "wo_total")
    private Double woTotal;
    @Column(name = "wo_balance")
    private Double woBalance;
    @Column(name = "wo_advance")
    private Double woAdvance;
    @OneToMany(mappedBy = "workOrderWorkOrderId", cascade = CascadeType.PERSIST)
    private List<Detail> detailList;
    @JoinColumn(name = "person_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person person;

    public WorkOrder() {
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

    public Integer getWoState() {
        return woState;
    }

    public void setWoState(Integer woState) {
        this.woState = woState;
    }

    public String getWoDescription() {
        return woDescription;
    }

    public void setWoDescription(String woDescription) {
        this.woDescription = woDescription;
    }

    public String getWoNumber() {
        return woNumber;
    }

    public void setWoNumber(String woNumber) {
        this.woNumber = woNumber;
    }

    public Date getWoIssueDate() {
        return woIssueDate;
    }

    public void setWoIssueDate(Date woIssueDate) {
        this.woIssueDate = woIssueDate;
    }

    public Date getWoDeliveryDate() {
        return woDeliveryDate;
    }

    public void setWoDeliveryDate(Date woDeliveryDate) {
        this.woDeliveryDate = woDeliveryDate;
    }

    public Double getWoTotal() {
        return woTotal;
    }

    public void setWoTotal(Double woTotal) {
        this.woTotal = woTotal;
    }

    public Double getWoBalance() {
        return woBalance;
    }

    public void setWoBalance(Double woBalance) {
        this.woBalance = woBalance;
    }

    public Double getWoAdvance() {
        return woAdvance;
    }

    public void setWoAdvance(Double woAdvance) {
        this.woAdvance = woAdvance;
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
    
}
