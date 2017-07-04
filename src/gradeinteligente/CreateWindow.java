/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.io.Serializable;
import javax.swing.JWindow;

/**
 *
 * @author robert
 */
public class CreateWindow extends JWindow {
    
    private Serializable entity;

    public CreateWindow(Serializable entity) {
        this.entity = entity;
        
        if(entity instanceof Professor){
            add(new CreateProfessorPanel());
        } else if(entity instanceof Disciplina){
            
        } else if(entity instanceof Turma){
            
        }
        
    }
    
}
