/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.modules;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pradip
 */
@Entity
@Table(name = "customer_car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerCar.findAll", query = "SELECT c FROM CustomerCar c")
    , @NamedQuery(name = "CustomerCar.findById", query = "SELECT c FROM CustomerCar c WHERE c.id = :id")
    , @NamedQuery(name = "CustomerCar.findByDate", query = "SELECT c FROM CustomerCar c WHERE c.date = :date")})
public class CustomerCar implements Serializable {

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
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CarPart carId;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customerId;

    public CustomerCar() {
    }

    public CustomerCar(Integer id) {
        this.id = id;
    }

    public CustomerCar(Integer id, Date date) {
        this.id = id;
        this.date = date;
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

    public CarPart getCarId() {
        return carId;
    }

    public void setCarId(CarPart carId) {
        this.carId = carId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
        if (!(object instanceof CustomerCar)) {
            return false;
        }
        CustomerCar other = (CustomerCar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workshop.modules.CustomerCar[ id=" + id + " ]";
    }
    
}
