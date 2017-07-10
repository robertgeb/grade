/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
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
 * @author robert
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findById", query = "SELECT h FROM Horario h WHERE h.id = :id")
    , @NamedQuery(name = "Horario.findByDia", query = "SELECT h FROM Horario h WHERE h.dia = :dia")
    , @NamedQuery(name = "Horario.findByHora", query = "SELECT h FROM Horario h WHERE h.hora = :hora")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dia")
    private Integer dia;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "turma", referencedColumnName = "id")
    @ManyToOne
    private Turma turma;
    @JoinColumn(name = "grade", referencedColumnName = "id")
    @ManyToOne
    private Grade grade;

    public Horario() {
    }

    public Horario(Integer id) {
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
    public int getHoraNormalizada(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getHora());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public void setHoraNormalizada(int hora){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        this.hora = calendar.getTime();
    }
    
    public void generateDiaHora(){
        if(grade == null)
            return;
        Collection<Horario> outrosHorarios = grade.getHorarioCollection();
        
        horaLoop: for (int i = 0; i < 4; i+=2) {
            diaLoop: for (int j = 0; j < 3; j++) {
                for (Horario outroHorario : outrosHorarios) {
                    if(outroHorario.getDia() == j && outroHorario.getHoraNormalizada()-8 == i && mesmoPeriodo(outroHorario))
                        continue diaLoop;
                }
                this.dia = j;
                this.setHoraNormalizada(i+8);
                return;
            }
        }
        horaLoop: for (int i = 5; i < 13; i+=2) {
            diaLoop: for (int j = 0; j < 3; j++) {
                for (Horario outroHorario : outrosHorarios) {
                    if(outroHorario.getDia() == j && outroHorario.getHoraNormalizada()-8 == i && mesmoPeriodo(outroHorario))
                        continue diaLoop;
                }
                this.dia = j;
                this.setHoraNormalizada(i+8);
                return;
            }
        }
        horaLoop: for (int i = 0; i < 13; i+=2) {
            diaLoop: for (int j = 0; j < 6; j++) {
                for (Horario outroHorario : outrosHorarios) {
                    if(outroHorario.getDia() == j && outroHorario.getHoraNormalizada()-8 == i && mesmoPeriodo(outroHorario))
                        continue diaLoop;
                }
                this.dia = j;
                this.setHoraNormalizada(i+8);
                return;
            }
        }
    }

    private boolean mesmoPeriodo(Horario outroHorario){
        return outroHorario.getTurma().getDisciplina().getPeriodo() == turma.getDisciplina().getPeriodo();
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
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gradeinteligente.Horario[ id=" + id + " ]";
    }
    
}
