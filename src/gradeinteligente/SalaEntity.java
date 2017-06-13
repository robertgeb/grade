/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robert
 */
@Entity
@Table(name = "sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalaEntity.findAll", query = "SELECT s FROM SalaEntity s")
    , @NamedQuery(name = "SalaEntity.findById", query = "SELECT s FROM SalaEntity s WHERE s.id = :id")
    , @NamedQuery(name = "SalaEntity.findByNumero", query = "SELECT s FROM SalaEntity s WHERE s.numero = :numero")})
public class SalaEntity implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer numero;
    @OneToMany(mappedBy = "sala")
    private Collection<HorarioEntity> horarioEntityCollection;
    @JoinColumn(name = "predio", referencedColumnName = "id")
    @ManyToOne
    private PredioEntity predio;

    public SalaEntity() {
    }

    public SalaEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        Integer oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    @XmlTransient
    public Collection<HorarioEntity> getHorarioEntityCollection() {
        return horarioEntityCollection;
    }

    public void setHorarioEntityCollection(Collection<HorarioEntity> horarioEntityCollection) {
        this.horarioEntityCollection = horarioEntityCollection;
    }

    public PredioEntity getPredio() {
        return predio;
    }

    public void setPredio(PredioEntity predio) {
        PredioEntity oldPredio = this.predio;
        this.predio = predio;
        changeSupport.firePropertyChange("predio", oldPredio, predio);
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
        if (!(object instanceof SalaEntity)) {
            return false;
        }
        SalaEntity other = (SalaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gradeinteligente.SalaEntity[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
