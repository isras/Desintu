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
@Table(name = "petition")
@NamedQueries({
    @NamedQuery(name = "Petition.findAll", query = "SELECT p FROM Petition p")})
public class Petition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "petition_id")
    private Long petitionId;
    @Column(name = "pt_name")
    private String ptName;
    @Column(name = "pt_issue_date")
    @Temporal(TemporalType.DATE)
    private Date ptIssueDate;
    @Column(name = "pt_state")
    private Boolean ptState;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pt_total")
    private Double ptTotal;
    @JoinColumn(name = "person_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person person;
    @OneToMany(mappedBy = "petition",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Detail> detailList;

    public Petition() {
        detailList = new ArrayList<>();
    }

    public Petition(Long petitionId) {
        this.petitionId = petitionId;
    }

    public Long getPetitionId() {
        return petitionId;
    }

    public void setPetitionId(Long petitionId) {
        this.petitionId = petitionId;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public Date getPtIssueDate() {
        return ptIssueDate;
    }

    public void setPtIssueDate(Date ptIssueDate) {
        this.ptIssueDate = ptIssueDate;
    }

    public Boolean getPtState() {
        return ptState;
    }

    public void setPtState(Boolean ptState) {
        this.ptState = ptState;
    }

    public Double getPtTotal() {
        return ptTotal;
    }

    public void setPtTotal(Double ptTotal) {
        this.ptTotal = ptTotal;
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
        hash += (petitionId != null ? petitionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Petition)) {
            return false;
        }
        Petition other = (Petition) object;
        if ((this.petitionId == null && other.petitionId != null) || (this.petitionId != null && !this.petitionId.equals(other.petitionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Petition[ petitionId=" + petitionId + " ]";
    }
    
}
