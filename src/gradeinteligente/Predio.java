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
public class Predio implements Model {
    
    private int id;
    private String nome;

    public Predio(int id, String nome) {
        this.id = id;
        this.nome = nome;
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
    
    @Override
    public void save() {
        if(this.id != -1)
            new Bd().update(this);
        else
            this.id = new Bd().insert(this);
    }

    @Override
    public String toSqlUpdate() {
        return "UPDATE predio "
                    + "SET nome = '" + this.nome + "' WHERE "
                    + "(id = " + this.id + ")";
    }

    @Override
    public String toSqlInsert() {
        return "INSERT INTO predio "
                    + "(nome) VALUES "
                    + "('" + this.nome + "')";
    }

    @Override
    public String toSqlFind() {
        return "SELECT * FROM predio WHERE id = " + this.id;
    }

    @Override
    public void setAttributesFromResultSet(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                "\nNome: " + this.nome;
    }
    
}
