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
public class SalaTest {
    
    private Sala sala;

    public SalaTest() {
        sala = new Sala(-1, new Predio(-1, "PAP"), 22);
        sala.save();
        System.out.println(sala);
        System.out.println(new Bd().find(new Sala(sala.getId(), null, -1)));
    }
    
    
}
