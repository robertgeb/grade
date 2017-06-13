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
public class PredioTest {
    
    private Predio predio;

    public PredioTest() {
        predio = new Predio(-1, "PAP");
        predio.save();
        System.out.println(predio);
        System.out.println(new Bd().find(new Predio(predio.getId(), "")));
        
        
    }
    
    
}
