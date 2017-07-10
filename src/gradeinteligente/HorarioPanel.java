/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.util.Calendar;

/**
 *
 * @author robert
 */
public class HorarioPanel extends javax.swing.JPanel {

    private Horario horario;
    
    /**
     * Creates new form HorarioListItemPanel
     */
    public HorarioPanel(Horario horario) {
        initComponents();
        this.horario = horario;
        disciplinaLabel.setText(horario.getTurma().getDisciplina().getAbreviatura() + " - " + horario.getTurma().getNome());
        professorLabel.setText(horario.getTurma().getProfessor().getNome());
        
    }

    public int getHoraNormalizada(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(horario.getHora());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getDia(){
        return horario.getDia();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        professorLabel = new javax.swing.JLabel();
        disciplinaLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        professorLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        professorLabel.setText("Professor");

        disciplinaLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        disciplinaLabel.setText("Disciplina");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(professorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(disciplinaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(disciplinaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel disciplinaLabel;
    private javax.swing.JLabel professorLabel;
    // End of variables declaration//GEN-END:variables
}