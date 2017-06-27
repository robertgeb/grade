/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.io.Serializable;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author robert
 */
public class SelectWindow extends javax.swing.JWindow {

    public SelectWindow(JFrame mainWindow, List<? extends Serializable> entityList) {
        super(mainWindow);
        this.setBounds(200,200,200,200);
        this.setBackground(new java.awt.Color(255, 255, 255));
        
        this.setVisible(true);
        this.add(new ListPanel(entityList));
        
    }
    
}
