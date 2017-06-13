/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.time.LocalDateTime;

/**
 *
 * @author robert
 */
public class GradeTest {
    
    private Grade grade;

    public GradeTest() {
        grade = new Grade(-1, LocalDateTime.now(), "teste");
        grade.save();
        System.out.println(grade);
        System.out.println(new Bd().find(new Grade(grade.getId(), null, null)));
    }
    
    
}
