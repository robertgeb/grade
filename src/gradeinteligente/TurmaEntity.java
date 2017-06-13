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
@Table(name = "turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurmaEntity.findAll", query = "SELECT t FROM TurmaEntity t")
    , @NamedQuery(name = "TurmaEntity.findById", query = "SELECT t FROM TurmaEntity t WHERE t.id = :id")
    , @NamedQuery(name = "TurmaEntity.findByNome", query = "SELECT t FROM TurmaEntity t WHERE t.nome = :nome")})
public class TurmaEntity implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "turma")
    private Collection<HorarioEntity> horarioEntityCollection;
    @JoinColumn(name = "disciplina", referencedColumnName = "id")
    @ManyToOne
    private DisciplinaEntity disciplina;
    @JoinColumn(name = "professor", referencedColumnName = "id")
    @ManyToOne
    private ProfessorEntity professor;

    public TurmaEntity() {
    }

    public TurmaEntity(Integer id) {
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

    @XmlTransient
    public Collection<HorarioEntity> getHorarioEntityCollection() {
        return horarioEntityCollection;
    }

    public void setHorarioEntityCollection(Collection<HorarioEntity> horarioEntityCollection) {
        this.horarioEntityCollection = horarioEntityCollection;
    }

    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        DisciplinaEntity oldDisciplina = this.disciplina;
        this.disciplina = disciplina;
        changeSupport.firePropertyChange("disciplina", oldDisciplina, disciplina);
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        ProfessorEntity oldProfessor = this.professor;
        this.professor = professor;
        changeSupport.firePropertyChange("professor", oldProfessor, professor);
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
        if (!(object instanceof TurmaEntity)) {
            return false;
        }
        TurmaEntity other = (TurmaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gradeinteligente.TurmaEntity[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
