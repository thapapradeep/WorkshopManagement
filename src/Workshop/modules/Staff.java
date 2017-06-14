/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.modules;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pradip
 */
@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findById", query = "SELECT s FROM Staff s WHERE s.id = :id")
    , @NamedQuery(name = "Staff.findByFname", query = "SELECT s FROM Staff s WHERE s.fname = :fname")
    , @NamedQuery(name = "Staff.findByLname", query = "SELECT s FROM Staff s WHERE s.lname = :lname")
    , @NamedQuery(name = "Staff.findByUsername", query = "SELECT s FROM Staff s WHERE s.username = :username")
    , @NamedQuery(name = "Staff.findByPassword", query = "SELECT s FROM Staff s WHERE s.password = :password")
    , @NamedQuery(name = "Staff.findByAddress", query = "SELECT s FROM Staff s WHERE s.address = :address")
    , @NamedQuery(name = "Staff.findByContact", query = "SELECT s FROM Staff s WHERE s.contact = :contact")})
public class Staff implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private Collection<Customer> customerCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private Collection<Attendence> attendenceCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "lname")
    private String lname;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "contact")
    private int contact;
    @JoinColumn(name = "staff_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StaffType staffTypeId;

    public Staff() {
    }

    public Staff(Integer id) {
        this.id = id;
    }

    public Staff(Integer id, String fname, String lname, String address, int contact) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public StaffType getStaffTypeId() {
        return staffTypeId;
    }

    public void setStaffTypeId(StaffType staffTypeId) {
        this.staffTypeId = staffTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workshop.modules.Staff[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Attendence> getAttendenceCollection() {
        return attendenceCollection;
    }

    public void setAttendenceCollection(Collection<Attendence> attendenceCollection) {
        this.attendenceCollection = attendenceCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }
    
}
