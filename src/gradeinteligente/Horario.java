/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

/**
 *
 * @author robert
 */
public class Horario implements Model {
    
    private int id;
    private Turma turma;
    private Sala sala;
    private LocalTime hora;
    private Grade grade;

    public Horario(int id, Turma turma, Sala sala, LocalTime hora, Grade grade) {
        this.id = id;
        this.turma = turma;
        this.sala = sala;
        this.hora = hora;
        this.grade = grade;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return the hora
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * @return the grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    @Override
    public void save() {
        this.turma.save();
        this.sala.save();
        this.grade.save();
        if(this.id != -1)
            new Bd().update(this);
        else
            this.id = new Bd().insert(this);
    }

    @Override
    public String toSqlUpdate() {
        return "UPDATE horario "
                    + "SET turma = " + this.turma.getId() + ", sala = " + this.sala.getId() + ", hora = '" + this.hora + "', grade = " + this.grade.getId() + " WHERE "
                    + "(id = " + this.id + ")";
    }

    @Override
    public String toSqlInsert() {
        return "INSERT INTO horario "
                    + "(turma, sala, hora, grade) VALUES "
                    + "(" + this.turma.getId() + ", " + this.sala.getId() + ", '" + this.hora + "' ," + this.grade.getId() + ")";
    }

    @Override
    public String toSqlFind() {
        return "SELECT * FROM horario WHERE id = " + this.id;
    }

    @Override
    public Model setAttributesFromResultSet(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.turma = (Turma) new Bd().find(new Turma(rs.getInt("turma"), null, null, null));
            this.sala = (Sala) new Bd().find(new Sala(rs.getInt("sala"), null, -1));
            this.hora = rs.getTime("hora").toLocalTime();
            this.grade = (Grade) new Bd().find(new Grade(rs.getInt("grade"), null, null));
            return this;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                "\nTurma: " + this.turma +
                "\nSala: " + this.sala +
                "\nHora: " + this.hora +
                "\nGrade: " + this.grade;
    }
    
    @Override
    public String toSqlFindAll() {
        return "SELECT * FROM horario";
    }
    
    
}
