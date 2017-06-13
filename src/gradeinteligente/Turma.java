/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author robert
 */
public class Turma implements Model {
    
    private int id;
    private String nome;
    private Professor professor;
    private Disciplina disciplina;

    public Turma(int id, String nome, Professor professor, Disciplina disciplina) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.disciplina = disciplina;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
    @Override
    public void save() {
        this.disciplina.save();
        this.professor.save();
        if(this.id != -1)
            new Bd().update(this);
        else
            this.id = new Bd().insert(this);
    }

    @Override
    public String toSqlUpdate() {
        return "UPDATE turma "
                    + "SET nome = '" + this.nome + "', professor = " + this.professor.getId() + ", disciplina = " + this.disciplina.getId() + " WHERE "
                    + "(id = " + this.id + ")";
    }

    @Override
    public String toSqlInsert() {
        return "INSERT INTO turma "
                    + "(nome, professor, disciplina) VALUES "
                    + "('" + this.nome + "', " + this.professor.getId() + ", " + this.disciplina.getId() + ")";
    }

    @Override
    public String toSqlFind() {
        return "SELECT * FROM turma WHERE id = " + this.id;
    }

    @Override
    public void setAttributesFromResultSet(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.professor = (Professor) new Bd().find(new Professor(rs.getInt("professor"), null, -1));
            this.disciplina = (Disciplina) new Bd().find(new Disciplina(rs.getInt("disciplina"), null, -1));
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                "\nNome: " + this.nome +
                "\nProfessor: " + this.professor +
                "\nDisciplina: " + this.disciplina;
    }
    
}
