/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author robert
 */
public class TurmaListItemPanel extends javax.swing.JPanel {

    Turma turma;
    
    /**
     * Creates new form TurmaPanel
     */
    public TurmaListItemPanel(Turma turma) {
        initComponents();
        this.turma = turma;
        initLabels();
    }
    
    private void initLabels() {
        nomeTurmaLabel.setText(turma.getNome().toString());
        nomeProfessorLabel.setText(turma.getProfessor().toString());
    }
    
    private void openMenu(MouseEvent evt) {
        Component turmaItemPanel = evt.getComponent();
        Component listaTurma = turmaItemPanel.getParent();
        Component listaWrapper = listaTurma.getParent();
        DisciplinaPanel disciplinaItemPanel = (DisciplinaPanel) listaWrapper.getParent();
        MouseEvent convertedMouseEvent = SwingUtilities.convertMouseEvent(turmaItemPanel, evt, disciplinaItemPanel.getParent());
        
        disciplinaItemPanel.openMenu(convertedMouseEvent, turma);
    }

    public Turma getTurma() {
        return turma;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        nomeTurmaLabel = new javax.swing.JLabel();
        nomeProfessorLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        nomeTurmaLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nomeTurmaLabel.setText("Nome");

        nomeProfessorLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nomeProfessorLabel.setText("Professor");

        jLabel1.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(nomeTurmaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeProfessorLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTurmaLabel)
                    .addComponent(nomeProfessorLabel)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        Component turmaItemPanel = evt.getComponent();
        Component listaTurma = turmaItemPanel.getParent();
        Component listaWrapper = listaTurma.getParent();
        Component disciplinaItemPanel = listaWrapper.getParent();
        // Convertendo evento
        MouseEvent convertMouseEvent = SwingUtilities.convertMouseEvent(turmaItemPanel, evt, disciplinaItemPanel.getParent());
        // Acionando evento do item pai
        disciplinaItemPanel.dispatchEvent(convertMouseEvent);
        
        setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        openMenu(evt);
    }//GEN-LAST:event_formMouseClicked

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(Color.white);
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nomeProfessorLabel;
    private javax.swing.JLabel nomeTurmaLabel;
    // End of variables declaration//GEN-END:variables
}
