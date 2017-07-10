/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author robert
 */
public class GradePopupMenu extends JPopupMenu {
    
    Grade grade;
    
    JMenuItem novaGradeItem;
    JMenuItem abrirGradeItem;
    JMenuItem apagarGradeItem;
    
    public GradePopupMenu(Grade grade) {
        this.grade = grade;
        
        novaGradeItem = new JMenuItem("Criar grade");
        abrirGradeItem = new JMenuItem("Abrir");
        apagarGradeItem = new JMenuItem("Apagar grade");
        
        novaGradeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getMainWindow().criarGrade();
            }
        });
        
        this.add(novaGradeItem);
        if(grade != null){
            this.add(abrirGradeItem);
            this.add(apagarGradeItem);
        }
            
    }
    
    private MainWindow getMainWindow(){
        return (MainWindow) SwingUtilities.getWindowAncestor(this.getInvoker());
    }
    
}
