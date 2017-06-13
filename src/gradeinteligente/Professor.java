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
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessorEntity.findAll", query = "SELECT p FROM ProfessorEntity p")
    , @NamedQuery(name = "ProfessorEntity.findById", query = "SELECT p FROM ProfessorEntity p WHERE p.id = :id")
    , @NamedQuery(name = "ProfessorEntity.findByNome", query = "SELECT p FROM ProfessorEntity p WHERE p.nome = :nome")
    , @NamedQuery(name = "ProfessorEntity.findByMatricula", query = "SELECT p FROM ProfessorEntity p WHERE p.matricula = :matricula")})
public class Professor implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String nome;
    private Integer matricula;
    @OneToMany(mappedBy = "professor")
    private Collection<Turma> turmaEntityCollection;

    public Professor() {
    }

    public Professor(Integer id) {
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

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        Integer oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    @XmlTransient
    public Collection<Turma> getTurmaEntityCollection() {
        return turmaEntityCollection;
    }

    public void setTurmaEntityCollection(Collection<Turma> turmaEntityCollection) {
        this.turmaEntityCollection = turmaEntityCollection;
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
