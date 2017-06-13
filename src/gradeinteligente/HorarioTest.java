/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author robert
 */
public class HorarioTest {
    
    private Horario horario;

    public HorarioTest() {
        horario = new Horario(-1, new Turma(-1, "T01", new Professor(-1, "xl", 10101), new Disciplina(-1, "Top Alg", 2)), new Sala(-1, new Predio(-1, "PAP"), 22), LocalTime.of(10,0), new Grade(-1, LocalDateTime.now(), "teste"));
        horario.save();
        System.out.println(horario);
        System.out.println(new Bd().find(new Horario(horario.getId(), null, null, null, null)));
    }
}
