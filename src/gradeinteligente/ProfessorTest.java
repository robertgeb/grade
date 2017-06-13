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
public class ProfessorTest {

    private Professor professor;
    
    public ProfessorTest() {
        professor = new Professor(-1, "Gizelle Kupac", 10101010);
        professor.save();
        System.out.println(professor);
        System.out.println(new Bd().find(new Professor(professor.getId(), null, -1)));
    }
    
    
    
}
