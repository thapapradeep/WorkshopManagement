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
@Table(name = "staff_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffType.findAll", query = "SELECT s FROM StaffType s")
    , @NamedQuery(name = "StaffType.findById", query = "SELECT s FROM StaffType s WHERE s.id = :id")
    , @NamedQuery(name = "StaffType.findByStaffType", query = "SELECT s FROM StaffType s WHERE s.staffType = :staffType")
    , @NamedQuery(name = "StaffType.findByDailyWage", query = "SELECT s FROM StaffType s WHERE s.dailyWage = :dailyWage")})
public class StaffType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "staff_type")
    private String staffType;
    @Basic(optional = false)
    @Column(name = "daily_wage")
    private float dailyWage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffTypeId")
    private Collection<Staff> staffCollection;

    public StaffType() {
    }

    public StaffType(Integer id) {
        this.id = id;
    }

    public StaffType(Integer id, String staffType, float dailyWage) {
        this.id = id;
        this.staffType = staffType;
        this.dailyWage = dailyWage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public float getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(float dailyWage) {
        this.dailyWage = dailyWage;
    }

    @XmlTransient
    public Collection<Staff> getStaffCollection() {
        return staffCollection;
    }

    public void setStaffCollection(Collection<Staff> staffCollection) {
        this.staffCollection = staffCollection;
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
        if (!(object instanceof StaffType)) {
            return false;
        }
        StaffType other = (StaffType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workshop.modules.StaffType[ id=" + id + " ]";
    }
    
}
