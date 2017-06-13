/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author robert
 */
@Entity
@Table(name = "predio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PredioEntity.findAll", query = "SELECT p FROM PredioEntity p")
    , @NamedQuery(name = "PredioEntity.findById", query = "SELECT p FROM PredioEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PredioEntity.findByNome", query = "SELECT p FROM PredioEntity p WHERE p.nome = :nome")})
public class Predio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "predio")
    private Collection<Sala> salaEntityCollection;

    public Predio() {
    }

    public Predio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Sala> getSalaEntityCollection() {
        return salaEntityCollection;
    }

    public void setSalaEntityCollection(Collection<Sala> salaEntityCollection) {
        this.salaEntityCollection = salaEntityCollection;
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
        if (!(object instanceof Predio)) {
            return false;
        }
        Predio other = (Predio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
