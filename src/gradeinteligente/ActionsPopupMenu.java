/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author robert
 */
public class ActionsPopupMenu extends JPopupMenu {
    
    JMenuItem editarDisciplinaItem;
    JMenuItem novaTurmaItem;
    JMenuItem apagarTurmaItem;
    
    Disciplina disciplina;
    Turma turma;
    MainWindow mainWindow;

    public ActionsPopupMenu(Disciplina disciplina, Turma turma) {
        
        this.disciplina = disciplina;
        this.turma = turma;
        
        
        novaTurmaItem = new JMenuItem("Nova turma");
        novaTurmaItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              criarTurma();
            }
        });
        editarDisciplinaItem = new JMenuItem("Editar Disciplina");
        editarDisciplinaItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              editarDisciplina();
            }
        });
        
        add(editarDisciplinaItem);
        
        add(novaTurmaItem);
        
        if(turma != null)
            adicionarOpcoesEspecificasTurma();
    }
    
    private void adicionarOpcoesEspecificasTurma(){
        apagarTurmaItem = new JMenuItem("Apagar turma " + this.turma.getNome());
        apagarTurmaItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              apagarTurma();
            }
        });
        
        add(apagarTurmaItem);
    }
    
    private void setMainWindow(){
        this.mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(this.getInvoker());
    }
    
    private void criarTurma(){
        setMainWindow();
        mainWindow.criarTurma(this.disciplina);
    }
    
    private void apagarTurma(){
        setMainWindow();
        mainWindow.apagarTurma(this.turma);
    }
    
    private void editarDisciplina(){
        setMainWindow();
        mainWindow.atualizarDisciplina(this.disciplina);
    }
    
}
