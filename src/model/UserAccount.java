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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jhoe
 */
@Entity
@Table(name = "user_account")
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccount u")})
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_account_id")
    private Long userAccountId;
    @Column(name = "usr_name")
    private String usrName;
    @Column(name = "usr_password")
    private String usrPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccount")
    private List<History> historyList;
    @JoinColumn(name = "rol_idrol", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private Rol rol;
    @JoinColumn(name = "usr_employee_id", referencedColumnName = "employee_id")
    @OneToOne
    private Employee employee;

    public UserAccount() {
    this.historyList = new ArrayList<>();
    }

    public UserAccount(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAccountId != null ? userAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.userAccountId == null && other.userAccountId != null) || (this.userAccountId != null && !this.userAccountId.equals(other.userAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserAccount[ userAccountId=" + userAccountId + " ]";
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
