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
public class QuadroHorariosPopupMenu extends JPopupMenu {
    
    JMenu mudarDiaMenu;
    JMenu mudarHoraMenu;
    ArrayList<JMenuItem> horaListItem;
    ArrayList<JMenuItem> diaListItem;
    
    Horario horario;
    MainWindow mainWindow;

    public QuadroHorariosPopupMenu(Horario horario) {
        
        this.horario = horario;
        
        mudarDiaMenu = new JMenu("Mudar dia");
        mudarHoraMenu = new JMenu("Mudar hora");
        
        diaListItem = new ArrayList<JMenuItem>();
        diaListItem.add(new JMenuItem("Segunda"));
        diaListItem.add(new JMenuItem("Terça"));
        diaListItem.add(new JMenuItem("Quarta"));
        diaListItem.add(new JMenuItem("Quinta"));
        diaListItem.add(new JMenuItem("Sexta"));
        diaListItem.add(new JMenuItem("Sábado"));
        
        for (JMenuItem diaItem : diaListItem) {
            diaItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    mudarDia(diaListItem.indexOf(diaItem));
                }
            });
            mudarDiaMenu.add(diaItem);
        }
        
        horaListItem = new ArrayList<JMenuItem>();
        for (int i = 0; i < 13; i++) {
            if(i>3)
                horaListItem.add(new JMenuItem((i+9) + "Horas"));
            else
                horaListItem.add(new JMenuItem((i+8) + "Horas"));
        }
        
        for (JMenuItem horaItem : horaListItem) {
            horaItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    mudarHora(horaListItem.indexOf(horaItem));
                }
            });
            mudarHoraMenu.add(horaItem);
        }
        
        add(mudarDiaMenu);
        add(mudarHoraMenu);
        
    }
    
    private void mudarDia(int dia){
        horario.setDia(dia);
        getMainWindow().atualizarHorario(horario);
    }
    
    private void mudarHora(int hora){
        if(hora<4)
            hora += 8;
        else
            hora += 9;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(horario.getHora());
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        horario.setHora(calendar.getTime());
        getMainWindow().atualizarHorario(horario);
    }
    
    private MainWindow getMainWindow(){
        return (MainWindow) SwingUtilities.getWindowAncestor(this.getInvoker());
    }
    
}
