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
public class DisciplinaTest {
    
    private Disciplina disciplina;

    public DisciplinaTest() {
        disciplina = new Disciplina(-1, "Tópicos em Algoritmos", 2);
        disciplina.save();
        System.out.println(disciplina);
        System.out.println(new Bd().find(new Disciplina(disciplina.getId(), "", -1)));
    }
    
    
}
