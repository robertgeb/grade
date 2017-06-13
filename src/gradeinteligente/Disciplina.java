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
public class Disciplina implements Model{
    
    private int id;
    private String nome;
    private int creditos;

    public Disciplina(int id, String nome, int creditos) {
        this.id = id;
        this.nome = nome;
        this.creditos = creditos;
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
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    @Override
    public void save() {
        if(this.id != -1)
            new Bd().update(this);
        else
            this.id = new Bd().insert(this);
    }

    @Override
    public String toSqlUpdate() {
        return "UPDATE disciplina "
                    + "SET nome = '" + this.nome + "', creditos = " + this.creditos + " WHERE "
                    + "(id = " + this.id + ")";
    }

    @Override
    public String toSqlInsert() {
        return "INSERT INTO disciplina "
                    + "(nome, creditos) VALUES "
                    + "('" + this.nome + "', " + this.creditos + ")";
    }

    @Override
    public String toSqlFind() {
        return "SELECT * FROM disciplina WHERE id = " + this.id;
    }

    @Override
    public Model setAttributesFromResultSet(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.creditos = rs.getInt("creditos");
            return this;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                "\nNome: " + this.nome +
                "\nCreditos: " + this.creditos;
    }
    
    @Override
    public String toSqlFindAll() {
        return "SELECT * FROM disciplina";
    }
    
}
