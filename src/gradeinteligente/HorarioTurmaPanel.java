/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

/**
 *
 * @author robert
 */
public class HorarioTurmaPanel extends javax.swing.JPanel {

    /**
     * Creates new form HorarioTurmaPanel
     */
    public HorarioTurmaPanel() {
        initComponents();
    }

    public void setTurma(String turma) {
        turmaLabel.setText(turma);
    }
    
    public void setProfessor(String professor) {
        professorLabel.setText(professor);
    }
    
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        turmaLabel = new javax.swing.JLabel();
        professorLabel = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        turmaLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        turmaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turmaLabel.setText("Turma");
        add(turmaLabel);

        professorLabel.setText("Professor");
        add(professorLabel);
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel professorLabel;
    private javax.swing.JLabel turmaLabel;
    // End of variables declaration//GEN-END:variables
}
