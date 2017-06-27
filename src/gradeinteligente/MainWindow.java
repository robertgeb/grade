/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.beansbinding.Binding;

/**
 *
 * @author robert
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        //new Bd();
        initComponents();
        initMainPanels();
    }
    
    public void persist(Serializable entity) {
        GradeInteligentePUEntityManager.getTransaction().begin();
        GradeInteligentePUEntityManager.persist(entity);
        GradeInteligentePUEntityManager.getTransaction().commit();
    }
    
    public JWindow professorSelectWindow(){
        return new SelectWindow(this, professorList);
    }
    
    public JWindow disciplinaSelectWindow(){
        return new SelectWindow(this, disciplinaList);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        GradeInteligentePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("GradeInteligentePU").createEntityManager();
        gradeQuery = java.beans.Beans.isDesignTime() ? null : GradeInteligentePUEntityManager.createQuery("SELECT g FROM Grade g");
        gradeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(gradeQuery.getResultList());
        turmaQuery = java.beans.Beans.isDesignTime() ? null : GradeInteligentePUEntityManager.createQuery("SELECT t FROM Turma t");
        turmaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(turmaQuery.getResultList());
        professorQuery = java.beans.Beans.isDesignTime() ? null : GradeInteligentePUEntityManager.createQuery("SELECT p FROM Professor p");
        professorList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(professorQuery.getResultList());
        salaQuery = java.beans.Beans.isDesignTime() ? null : GradeInteligentePUEntityManager.createQuery("SELECT s FROM Sala s");
        salaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(salaQuery.getResultList());
        disciplinaQuery = java.beans.Beans.isDesignTime() ? null : GradeInteligentePUEntityManager.createQuery("SELECT d FROM Disciplina d");
        disciplinaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(disciplinaQuery.getResultList());
        predioQuery = java.beans.Beans.isDesignTime() ? null : GradeInteligentePUEntityManager.createQuery("SELECT p FROM Predio p");
        predioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(predioQuery.getResultList());
        menuPanel = new javax.swing.JPanel();
        gradesMenuPanel = new javax.swing.JPanel();
        gradesLabel = new javax.swing.JLabel();
        horariosMenuPanel = new javax.swing.JPanel();
        horariosMenuLabel = new javax.swing.JLabel();
        alocacoesMenuPanel = new javax.swing.JPanel();
        alocacoesMenuLabel = new javax.swing.JLabel();
        turmasMenuPanel = new javax.swing.JPanel();
        turmasLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        menuPanel.setForeground(java.awt.Color.white);
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new java.awt.GridLayout(1, 4));

        gradesMenuPanel.setBackground(new java.awt.Color(188, 75, 81));

        gradesLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gradesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradesLabel.setText("Grades");
        gradesLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradesLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout gradesMenuPanelLayout = new javax.swing.GroupLayout(gradesMenuPanel);
        gradesMenuPanel.setLayout(gradesMenuPanelLayout);
        gradesMenuPanelLayout.setHorizontalGroup(
            gradesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradesMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        gradesMenuPanelLayout.setVerticalGroup(
            gradesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradesMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(gradesMenuPanel);

        horariosMenuPanel.setBackground(new java.awt.Color(253, 231, 76));

        horariosMenuLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        horariosMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horariosMenuLabel.setText("Horarios");
        horariosMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horariosMenuLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout horariosMenuPanelLayout = new javax.swing.GroupLayout(horariosMenuPanel);
        horariosMenuPanel.setLayout(horariosMenuPanelLayout);
        horariosMenuPanelLayout.setHorizontalGroup(
            horariosMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(horariosMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(horariosMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        horariosMenuPanelLayout.setVerticalGroup(
            horariosMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(horariosMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(horariosMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(horariosMenuPanel);

        alocacoesMenuPanel.setBackground(new java.awt.Color(91, 192, 235));

        alocacoesMenuLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        alocacoesMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alocacoesMenuLabel.setText("Alocações");
        alocacoesMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alocacoesMenuLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout alocacoesMenuPanelLayout = new javax.swing.GroupLayout(alocacoesMenuPanel);
        alocacoesMenuPanel.setLayout(alocacoesMenuPanelLayout);
        alocacoesMenuPanelLayout.setHorizontalGroup(
            alocacoesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alocacoesMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alocacoesMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        alocacoesMenuPanelLayout.setVerticalGroup(
            alocacoesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alocacoesMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alocacoesMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(alocacoesMenuPanel);

        turmasMenuPanel.setBackground(new java.awt.Color(155, 197, 61));

        turmasLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        turmasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turmasLabel.setText("Turmas");
        turmasLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turmasLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout turmasMenuPanelLayout = new javax.swing.GroupLayout(turmasMenuPanel);
        turmasMenuPanel.setLayout(turmasMenuPanelLayout);
        turmasMenuPanelLayout.setHorizontalGroup(
            turmasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(turmasMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turmasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        turmasMenuPanelLayout.setVerticalGroup(
            turmasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(turmasMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turmasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(turmasMenuPanel);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(java.awt.Color.white);
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new javax.swing.OverlayLayout(mainPanel));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void gradesLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradesLabelMouseClicked
       
    }//GEN-LAST:event_gradesLabelMouseClicked

    private void turmasLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turmasLabelMouseClicked
    
    }//GEN-LAST:event_turmasLabelMouseClicked

    private void horariosMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horariosMenuLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_horariosMenuLabelMouseClicked

    private void alocacoesMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alocacoesMenuLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_alocacoesMenuLabelMouseClicked

    private void initMainPanels(){
        mainPanelList = new ArrayList<JPanel>();
        mainPanelList.add(new GradesPanel());
        mainPanelList.add(new HorariosPanel(new Grade()));
        mainPanelList.add(new AlocacoesPanel());
        mainPanelList.add(new ListPanel(turmaList));
        
        mainPanel.removeAll();
        JScrollPane scroll = new JScrollPane(mainPanelList.get(3));
        scroll.getVerticalScrollBar().setUnitIncrement(17);
        mainPanel.add(scroll);
    }
    
    private void setSaved(String entity){
        toSaveList.remove(entity);
        JLabel entityTabLabel = getTabLabel(entity);
        entityTabLabel.setText(
                entityTabLabel.getText()
                        .substring(
                                0, 
                                entityTabLabel
                                        .getText()
                                        .length() - 1
                        )
        );
       
    }
    
    private void setToSave(String entity){
        if(toSaveList.add(entity)){
            JLabel entityTabLabel = getTabLabel(entity);
            entityTabLabel.setText(entityTabLabel.getText() + "*");
        }
    }
    
    private JLabel getTabLabel(String entity){
        switch(entity) {
            case GRADE:
                return gradesLabel;
                
            case TURMA:
                return turmasLabel;
                
        }
        return null;
    }
    
    private Serializable getSelectedEntity() {
        switch(getOpenedTabName()) {
            case GRADE:
                return new Grade();
                
            case PROFESSOR:
                return new Professor();
            
            case SALA:
                return new Sala();
             
            case TURMA:
                return new Turma();
            
            case DISCIPLINA:
                return new Disciplina();
             
            case PREDIO:
                return new Predio();
        }
        return null;
    }
    
    private List<?> getSelectedList(){
        switch(getOpenedTabName()) {
            case GRADE:
                return gradeList;
                
            case PROFESSOR:
                return professorList;
            
            case SALA:
                return salaList;
             
            case TURMA:
                return turmaList;
            
            case DISCIPLINA:
                return disciplinaList;
                
            case PREDIO:
                return predioList;
        }
        return null;
    }
    
    private String getOpenedTabName() {
        javax.swing.JPanel activedTab = null;
        for(Component panel : mainPanel.getComponents() ) {   
            if(panel.isEnabled())
                activedTab = (javax.swing.JPanel) panel;
        }
        if(activedTab == null || activedTab.getName() == null)
            return null;
        return activedTab.getName();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext", "true");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    private final String GRADE = "grade";
    private final String SALA = "salas";
    private final String PREDIO = "predio";
    private final String PROFESSOR = "professores";
    private final String TURMA = "turmas";
    private final String DISCIPLINA = "disciplina";
    private final String DEFAULT_ERROR_MESSAGE = "Erro inesperado, Reinicie a aplicação";
    private final String SELECTED_ROW_ERROR_MESSAGE = "Selecione o item para esta ação";
    private Set<String> toSaveList = new HashSet<String>();
    private ArrayList<JPanel> mainPanelList;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager GradeInteligentePUEntityManager;
    private javax.swing.JLabel alocacoesMenuLabel;
    private javax.swing.JPanel alocacoesMenuPanel;
    private java.util.List<gradeinteligente.Disciplina> disciplinaList;
    private javax.persistence.Query disciplinaQuery;
    private java.util.List<gradeinteligente.Grade> gradeList;
    private javax.persistence.Query gradeQuery;
    private javax.swing.JLabel gradesLabel;
    private javax.swing.JPanel gradesMenuPanel;
    private javax.swing.JLabel horariosMenuLabel;
    private javax.swing.JPanel horariosMenuPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private java.util.List<gradeinteligente.Predio> predioList;
    private javax.persistence.Query predioQuery;
    private java.util.List<gradeinteligente.Professor> professorList;
    private javax.persistence.Query professorQuery;
    private java.util.List<gradeinteligente.Sala> salaList;
    private javax.persistence.Query salaQuery;
    private java.util.List<gradeinteligente.Turma> turmaList;
    private javax.persistence.Query turmaQuery;
    private javax.swing.JLabel turmasLabel;
    private javax.swing.JPanel turmasMenuPanel;
    // End of variables declaration//GEN-END:variables
}
