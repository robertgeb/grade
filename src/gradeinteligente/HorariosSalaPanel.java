package gradeinteligente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robert
 */
public class HorariosSalaPanel extends javax.swing.JPanel {

    /**
     * Creates new form HorariosSalaPanel
     */
    public HorariosSalaPanel(Sala sala) {
        initComponents();
        numeroLabel.setText(sala.toString() + " -");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        numeroLabel = new javax.swing.JLabel();

        setOpaque(false);

        numeroLabel.setText("Numero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numeroLabel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numeroLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel numeroLabel;
    // End of variables declaration//GEN-END:variables
}
