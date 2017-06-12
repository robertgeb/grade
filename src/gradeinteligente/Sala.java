/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

/**
 *
 * @author robert
 */
public class Sala {
    
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
    
    
}
