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
public class Professor implements Model{
    
    private int id;
    private String nome;
    private int matricula;

    public Professor(int id, String nome, int matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public void save() {
        if(this.id != -1)
            new Bd().update(this);
        else
            this.id = new Bd().insert(this);
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
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " Nome: " + this.nome + " Matricula: " + this.matricula;
    }
    
    
    @Override
    public String toSqlUpdate() {
        return "UPDATE professor"
                    + "SET nome = " + this.nome + ", matricula = " + this.matricula + " WHERE "
                    + "(id = " + this.id + ")";
    }

    @Override
    public String toSqlInsert() {
        return "INSERT INTO professor "
                    + "(nome, matricula) VALUES "
                    + "('" + this.nome + "', " + this.matricula + ")";
    }

    @Override
    public String toSqlFind() {
        return "SELECT * FROM professor WHERE id = " + this.id;
    }

    @Override
    public Model setAttributesFromResultSet(ResultSet rs) {
        System.out.println(this);
        try {
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.matricula = rs.getInt("matricula");
            System.out.println(this);
            return new Professor(id, nome, matricula);
        } catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String toSqlFindAll() {
        return "SELECT * FROM professor";
    }
    
    
}
