/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.modules;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pradip
 */
@Entity
@Table(name = "attendence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendence.findAll", query = "SELECT a FROM Attendence a")
    , @NamedQuery(name = "Attendence.findById", query = "SELECT a FROM Attendence a WHERE a.id = :id")
    , @NamedQuery(name = "Attendence.findByDate", query = "SELECT a FROM Attendence a WHERE a.date = :date")
    , @NamedQuery(name = "Attendence.findByStatus", query = "SELECT a FROM Attendence a WHERE a.status = :status")})
public class Attendence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Staff staffId;

    public Attendence() {
    }

    public Attendence(Integer id) {
        this.id = id;
    }

    public Attendence(Integer id, Date date, String status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
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
        if (!(object instanceof Attendence)) {
            return false;
        }
        Attendence other = (Attendence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workshop.modules.Attendence[ id=" + id + " ]";
    }
    
}
