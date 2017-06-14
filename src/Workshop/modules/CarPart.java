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
@Table(name = "car_part")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarPart.findAll", query = "SELECT c FROM CarPart c")
    , @NamedQuery(name = "CarPart.findById", query = "SELECT c FROM CarPart c WHERE c.id = :id")
    , @NamedQuery(name = "CarPart.findByName", query = "SELECT c FROM CarPart c WHERE c.name = :name")
    , @NamedQuery(name = "CarPart.findByType", query = "SELECT c FROM CarPart c WHERE c.type = :type")
    , @NamedQuery(name = "CarPart.findByPrice", query = "SELECT c FROM CarPart c WHERE c.price = :price")
    , @NamedQuery(name = "CarPart.findByAvailableUnit", query = "SELECT c FROM CarPart c WHERE c.availableUnit = :availableUnit")})
public class CarPart implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    private Collection<CustomerCar> customerCarCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "available_unit")
    private int availableUnit;
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CarModel modelId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierId;

    public CarPart() {
    }

    public CarPart(Integer id) {
        this.id = id;
    }

    public CarPart(Integer id, String name, String type, float price, int availableUnit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.availableUnit = availableUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailableUnit() {
        return availableUnit;
    }

    public void setAvailableUnit(int availableUnit) {
        this.availableUnit = availableUnit;
    }

    public CarModel getModelId() {
        return modelId;
    }

    public void setModelId(CarModel modelId) {
        this.modelId = modelId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
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
        if (!(object instanceof CarPart)) {
            return false;
        }
        CarPart other = (CarPart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workshop.modules.CarPart[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<CustomerCar> getCustomerCarCollection() {
        return customerCarCollection;
    }

    public void setCustomerCarCollection(Collection<CustomerCar> customerCarCollection) {
        this.customerCarCollection = customerCarCollection;
    }
    
}
