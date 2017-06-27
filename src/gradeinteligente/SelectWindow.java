/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.io.Serializable;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author robert
 */
public class SelectWindow extends javax.swing.JWindow {

    Serializable entity;
    
    public SelectWindow(JFrame mainWindow, List<? extends Serializable> entityList) {
        super(mainWindow);
        this.setSize(400,400);
        this.setBackground(new java.awt.Color(255, 255, 255));
        
        this.setVisible(true);
        JScrollPane scroll = new JScrollPane(new ListPanel(entityList));
        scroll.getVerticalScrollBar().setUnitIncrement(17);
        scroll.setHorizontalScrollBar(null);
        this.add(scroll);
    }
    
    public Serializable getSelected(){
        return entity;
    }
    
    public void setSelected(Serializable entity){
        this.entity = entity;
    }
    
}
