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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robert
 */
@Entity
@Table(name = "grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradeEntity.findAll", query = "SELECT g FROM GradeEntity g")
    , @NamedQuery(name = "GradeEntity.findById", query = "SELECT g FROM GradeEntity g WHERE g.id = :id")
    , @NamedQuery(name = "GradeEntity.findByNome", query = "SELECT g FROM GradeEntity g WHERE g.nome = :nome")
    , @NamedQuery(name = "GradeEntity.findByCriacao", query = "SELECT g FROM GradeEntity g WHERE g.criacao = :criacao")})
public class GradeEntity implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;
    @OneToMany(mappedBy = "grade")
    private Collection<HorarioEntity> horarioEntityCollection;

    public GradeEntity() {
    }

    public GradeEntity(Integer id) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        Date oldCriacao = this.criacao;
        this.criacao = criacao;
        changeSupport.firePropertyChange("criacao", oldCriacao, criacao);
    }

    @XmlTransient
    public Collection<HorarioEntity> getHorarioEntityCollection() {
        return horarioEntityCollection;
    }

    public void setHorarioEntityCollection(Collection<HorarioEntity> horarioEntityCollection) {
        this.horarioEntityCollection = horarioEntityCollection;
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
        if (!(object instanceof GradeEntity)) {
            return false;
        }
        GradeEntity other = (GradeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gradeinteligente.GradeEntity[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}