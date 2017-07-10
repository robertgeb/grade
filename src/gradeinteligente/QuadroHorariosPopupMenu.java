/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author robert
 */
public class QuadroHorariosPopupMenu extends JPopupMenu {
    
    JMenu mudarDiaMenu;
    JMenu mudarHoraMenu;
    JMenuItem hora8Item;
    JMenuItem hora9Item;
    JMenuItem hora10Item;
    JMenuItem hora11Item;
    JMenuItem hora13Item;
    JMenuItem hora14Item;
    JMenuItem hora15Item;
    JMenuItem hora16Item;
    JMenuItem hora17Item;
    JMenuItem hora18Item;
    JMenuItem hora19Item;
    JMenuItem hora20Item;
    JMenuItem hora21Item;
    JMenuItem dia0Item;
    JMenuItem dia1Item;
    JMenuItem dia2Item;
    JMenuItem dia3Item;
    JMenuItem dia4Item;
    JMenuItem dia5Item;
    
    Horario horario;
    MainWindow mainWindow;

    public QuadroHorariosPopupMenu(Horario horario) {
        
        this.horario = horario;
        
        mudarDiaMenu = new JMenu("Mudar dia");
        mudarHoraMenu = new JMenu("Mudar hora");
        
        hora8Item = new JMenuItem("8 horas");
        hora9Item = new JMenuItem("9 horas");
        hora10Item = new JMenuItem("10 horas");
        hora11Item = new JMenuItem("11 horas");
        hora13Item = new JMenuItem("13 horas");
        hora14Item = new JMenuItem("14 horas");
        hora15Item = new JMenuItem("15 horas");
        hora16Item = new JMenuItem("16 horas");
        hora17Item = new JMenuItem("17 horas");
        hora18Item = new JMenuItem("18 horas");
        hora19Item = new JMenuItem("19 horas");
        hora20Item = new JMenuItem("20 horas");
        hora21Item = new JMenuItem("21 horas");
        
        mudarHoraMenu.add(hora8Item);
        mudarHoraMenu.add(hora9Item);
        mudarHoraMenu.add(hora10Item);
        mudarHoraMenu.add(hora11Item);
        mudarHoraMenu.add(hora13Item);
        mudarHoraMenu.add(hora14Item);
        mudarHoraMenu.add(hora15Item);
        mudarHoraMenu.add(hora16Item);
        mudarHoraMenu.add(hora17Item);
        mudarHoraMenu.add(hora18Item);
        mudarHoraMenu.add(hora19Item);
        mudarHoraMenu.add(hora20Item);
        mudarHoraMenu.add(hora21Item);
        
        dia0Item = new JMenuItem("Segunda");
        dia1Item = new JMenuItem("Terça");
        dia2Item = new JMenuItem("Quarta");
        dia3Item = new JMenuItem("Quinta");
        dia4Item = new JMenuItem("Sexta");
        dia5Item = new JMenuItem("Sábado");
        
        mudarDiaMenu.add(dia0Item);
        mudarDiaMenu.add(dia1Item);
        mudarDiaMenu.add(dia2Item);
        mudarDiaMenu.add(dia3Item);
        mudarDiaMenu.add(dia4Item);
        mudarDiaMenu.add(dia5Item);
        
        add(mudarDiaMenu);
        add(mudarHoraMenu);
    }
    
    private void setMainWindow(){
        this.mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(this.getInvoker());
    }
    
}
