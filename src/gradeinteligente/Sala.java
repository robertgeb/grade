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
public class Sala implements Model {
    
    private int id;
    private Predio predio;
    private int numero;

    public Sala(int id, Predio predio, int numero) {
        this.id = id;
        this.predio = predio;
        this.numero = numero;
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
     * @return the predio
     */
    public Predio getPredio() {
        return predio;
    }

    /**
     * @param predio the predio to set
     */
    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public void save() {
        predio.save();
        System.out.println(predio);
        if(this.id != -1)
            new Bd().update(this);
        else
            this.id = new Bd().insert(this);
        
    }
    
    @Override
    public String toSqlUpdate() {
        return "UPDATE sala"
                    + "SET numero = " + this.numero + ", predio = " + this.predio.getId() + " WHERE "
                    + "(id = " + this.id + ")";
    }

    @Override
    public String toSqlInsert() {
        return "INSERT INTO sala "
                    + "(numero, predio) VALUES "
                    + "(" + this.numero + ", " + this.predio.getId() + ")";
    }

    @Override
    public String toSqlFind() {
        return "SELECT * FROM sala WHERE id = " + this.id;
    }

    @Override
    public void setAttributesFromResultSet(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.numero = rs.getInt("numero");
            this.predio = (Predio) new Bd().find(new Predio(rs.getInt("predio"), null));
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                "\nNumero: " + this.numero +
                "\nPredio: " + this.predio;
    }
}
