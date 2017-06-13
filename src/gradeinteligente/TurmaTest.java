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
public class TurmaTest {
    
    private Turma turma;

    public TurmaTest() {
        turma = new Turma(-1, "T01", new Professor(-1, "xl", 10101), new Disciplina(-1, "Top Alg", 2));
        turma.save();
        System.out.println(turma);
        System.out.println(new Bd().find(new Turma(turma.getId(), null, null, null)));
    }
}
