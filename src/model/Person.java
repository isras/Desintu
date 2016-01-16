/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jhoe
 */
@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "pr_type")
    private String prType;
    @Column(name = "pr_first_name")
    private String prFirstName;
    @Column(name = "pr_last_name")
    private String prLastName;
    @Lob
    @Column(name = "pr_address")
    private String prAddress;
    @Column(name = "pr_email")
    private String prEmail;
    @Column(name = "pr_phone")
    private String prPhone;
    @Column(name = "pr_identification")
    private String prIdentification;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Sellnote> sellnoteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Petition> petitionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Invoice> invoiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<WorkOrder> workOrderList;

    public Person() {
        sellnoteList = new ArrayList<>();
        petitionList = new ArrayList<>();
        invoiceList = new ArrayList<>();
        workOrderList = new ArrayList<>();
    }

    public Person(Long personId) {
        this.personId = personId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPrFirstName() {
        return prFirstName;
    }

    public void setPrFirstName(String prFirstName) {
        this.prFirstName = prFirstName;
    }

    public String getPrLastName() {
        return prLastName;
    }

    public void setPrLastName(String prLastName) {
        this.prLastName = prLastName;
    }

    public String getPrAddress() {
        return prAddress;
    }

    public void setPrAddress(String prAddress) {
        this.prAddress = prAddress;
    }

    public String getPrEmail() {
        return prEmail;
    }

    public void setPrEmail(String prEmail) {
        this.prEmail = prEmail;
    }

    public String getPrPhone() {
        return prPhone;
    }

    public void setPrPhone(String prPhone) {
        this.prPhone = prPhone;
    }

    public String getPrIdentification() {
        return prIdentification;
    }

    public void setPrIdentification(String prIdentification) {
        this.prIdentification = prIdentification;
    }

    public List<Sellnote> getSellnoteList() {
        return sellnoteList;
    }

    public void setSellnoteList(List<Sellnote> sellnoteList) {
        this.sellnoteList = sellnoteList;
    }

    public List<Petition> getPetitionList() {
        return petitionList;
    }

    public void setPetitionList(List<Petition> petitionList) {
        this.petitionList = petitionList;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return prFirstName + " " + prLastName;
    }

    /**
     * @return the prType
     */
    public String getPrType() {
        return prType;
    }

    /**
     * @param prType the prType to set
     */
    public void setPrType(String prType) {
        this.prType = prType;
    }

    public List<WorkOrder> getWorkOrderList() {
        return workOrderList;
    }

    public void setWorkOrderList(List<WorkOrder> workOrderList) {
        this.workOrderList = workOrderList;
    }    
}