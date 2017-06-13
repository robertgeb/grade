/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
 * @author robert
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioEntity.findAll", query = "SELECT h FROM HorarioEntity h")
    , @NamedQuery(name = "HorarioEntity.findById", query = "SELECT h FROM HorarioEntity h WHERE h.id = :id")
    , @NamedQuery(name = "HorarioEntity.findByDia", query = "SELECT h FROM HorarioEntity h WHERE h.dia = :dia")
    , @NamedQuery(name = "HorarioEntity.findByHora", query = "SELECT h FROM HorarioEntity h WHERE h.hora = :hora")})
public class HorarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer dia;
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "sala", referencedColumnName = "id")
    @ManyToOne
    private SalaEntity sala;
    @JoinColumn(name = "turma", referencedColumnName = "id")
    @ManyToOne
    private TurmaEntity turma;
    @JoinColumn(name = "grade", referencedColumnName = "id")
    @ManyToOne
    private GradeEntity grade;

    public HorarioEntity() {
    }

    public HorarioEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public SalaEntity getSala() {
        return sala;
    }

    public void setSala(SalaEntity sala) {
        this.sala = sala;
    }

    public TurmaEntity getTurma() {
        return turma;
    }

    public void setTurma(TurmaEntity turma) {
        this.turma = turma;
    }

    public GradeEntity getGrade() {
        return grade;
    }

    public void setGrade(GradeEntity grade) {
        this.grade = grade;
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
        if (!(object instanceof HorarioEntity)) {
            return false;
        }
        HorarioEntity other = (HorarioEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gradeinteligente.HorarioEntity[ id=" + id + " ]";
    }
    
}
