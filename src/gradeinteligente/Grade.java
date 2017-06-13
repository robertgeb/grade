/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author robert
 */
public class Grade implements Model {

    private int id;
    private LocalDateTime criacao;
    private String nome;

    public Grade(int id, LocalDateTime criacao, String nome) {
        this.id = id;
        this.criacao = criacao;
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
     * @return the criacao
     */
    public LocalDateTime getCriacao() {
        return criacao;
    }

    /**
     * @param criacao the criacao to set
     */
    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
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
        return "UPDATE grade "
                    + "SET nome = '" + this.nome + "', criacao = " + this.criacao + " WHERE "
                    + "(id = " + this.id + ")";
    }

    @Override
    public String toSqlInsert() {
        return "INSERT INTO grade "
                    + "(nome, criacao) VALUES "
                    + "('" + this.nome + "', '" + this.criacao + "')";
    }

    @Override
    public String toSqlFind() {
        return "SELECT * FROM grade WHERE id = " + this.id;
    }

    @Override
    public void setAttributesFromResultSet(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.criacao = rs.getTimestamp("criacao").toLocalDateTime();
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                "\nNome: " + this.nome +
                "\nCriação: " + this.criacao;
    }
}
