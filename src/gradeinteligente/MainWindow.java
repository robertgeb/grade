/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JWindow;

/**
 *
 * @author robert
 */
public class MainWindow extends javax.swing.JFrame {

    ListPanel disciplinasTurmasListPanel;
    ListPanel gradeListPanel;
    QuadroHorariosPanel gradeHorariosPanel;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        //new Bd();
        initComponents();
        initTabEvents();
        initMainPanel();
    }
    
    /**
     * Salva nova entidade no banco ou atualiza uma ja existente
     */
    public void save(Serializable entity) {
        GradeInteligentePUEntityManager.getTransaction().begin();
        GradeInteligentePUEntityManager.persist(entity);
        GradeInteligentePUEntityManager.getTransaction().commit();
    }
    
    /**
     *  Abre uma janela para inserção dos dados, cria uma nova turma, e recarrega a lista de turmas
     */
    public void criarTurma(Disciplina disciplina) {
        JComboBox professoresComboBox = new JComboBox(professorList.toArray());
        JTextField nomeTurma = new JTextField();
        
        // Configurando campos da janela
        JComponent[] inputs = new JComponent[] {
            new JLabel("Nome"),
            nomeTurma,
            new JLabel("Professor"),
            professoresComboBox
        };
        
        int result = JOptionPane.showConfirmDialog(this
                , inputs
                , "Criar turma para "+disciplina.getNome()
                , JOptionPane.OK_CANCEL_OPTION);
        
        if(result != JOptionPane.CANCEL_OPTION){
            Turma novaTurma = new Turma();
            novaTurma.setNome(nomeTurma.getText());
            novaTurma.setDisciplina(disciplina);
            novaTurma.setProfessor((Professor) professoresComboBox.getSelectedItem());
            save(novaTurma);
            disciplina.getTurmaCollection().add(novaTurma);
            disciplinasTurmasListPanel.reload();
        }
    }
    
    public void criarGrade(){
        
        JComponent[] inputs = new JComponent[turmaList.size()+1];
        int i = 0;
        inputs[i] =  new JLabel("Selecione as turmas");
        i++;
        for (Turma turma : turmaList) {
            inputs[i] = new JCheckBox(turma.getDisciplina().getAbreviatura() + " - " + turma.getNome() + " P: "+ turma.getDisciplina().getPeriodo());
            ((JCheckBox)inputs[i]).setSelected(true);
            i++;
        }
        
        int result = JOptionPane.showConfirmDialog(this
                , inputs
                , "Criar nova grade"
                , JOptionPane.OK_CANCEL_OPTION);
        
        if(result != JOptionPane.CANCEL_OPTION){
            Grade novaGrade = new Grade();
            novaGrade.setCriacao(Calendar.getInstance().getTime());
            novaGrade.setNome("Teste");
            save(novaGrade);
            for (Turma turma : turmaList) {
                // Se a tuma estava selecionada cria horario
                if(inputs[turmaList.indexOf(turma)+1] instanceof JCheckBox && ((JCheckBox)inputs[turmaList.indexOf(turma)+1]).isSelected()){
                    Horario novoHorario = new Horario();
                    novoHorario.setGrade(novaGrade);
                    novoHorario.setTurma(turma);
                    novoHorario.generateDiaHora();
                    novaGrade.getHorarioCollection().add(novoHorario);
                    save(novoHorario);
                }
            }
            showGrade(novaGrade);
        }
    }
    
    
    
    /**
     *  Apaga turma e recarrega lista de turmas
     */
    public void apagarTurma(Turma turma) {
        GradeInteligentePUEntityManager.getTransaction().begin();
        GradeInteligentePUEntityManager.remove(turma);
        GradeInteligentePUEntityManager.getTransaction().commit();
        turma.getDisciplina().getTurmaCollection().remove(turma);
        disciplinasTurmasListPanel.reload();
    }
    
    /**
     *  Abre uma janela para atualizar os dados de uma disciplina
     */
    public void modificarDisciplina(Disciplina disciplina){
        JTextField nomeDisciplina = new JTextField();
        JSpinner creditosDisciplina = new JSpinner();
        JSpinner periodoDisciplina = new JSpinner();
        nomeDisciplina.setText(disciplina.getNome());
        creditosDisciplina.setValue(disciplina.getCreditos());
        periodoDisciplina.setValue(disciplina.getPeriodo());
        
        JComponent[] inputs = new JComponent[] {
            new JLabel("Nome"),
            nomeDisciplina,
            new JLabel("Creditos"),
            creditosDisciplina,
            new JLabel("Periodo"),
            periodoDisciplina
        };
        
        int result = JOptionPane.showConfirmDialog(this
                , inputs
                , "Editar disciplina "+disciplina.getNome()
                , JOptionPane.OK_CANCEL_OPTION);
        
        if(result == JOptionPane.CANCEL_OPTION){
            return;
        }
        else {
            disciplina.setNome(nomeDisciplina.getText());
            disciplina.setCreditos((int)creditosDisciplina.getValue());
            disciplina.setPeriodo((int)periodoDisciplina.getValue());
            save(disciplina);
            disciplinasTurmasListPanel.reload();
        }
    }
    
    /**
     *  Salva o horario e atualiza a lista de horarios
     */
    public void atualizarHorario(Horario horario){
        save(horario);
        if(gradeHorariosPanel != null){
            gradeHorariosPanel.atualizar();
        }
    }
    
    /**
     *  Configuração inicial dos eventos do mouse com as abas do topo
     */
    private void initTabEvents(){
        gradesMenuPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                showGradesList();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                gradesLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                gradesLabel.setBorder(null);
            }
        });
        
        turmasMenuPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                showTurmasList();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                turmasLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                turmasLabel.setBorder(null);
            }
        });
    }
    
    /**
     *  Configuração inicial do painel principal
     */
    private void initMainPanel(){
        disciplinasTurmasListPanel = new ListPanel(disciplinaList);
        
        mainPanel.removeAll();
        JScrollPane scroll = new JScrollPane(disciplinasTurmasListPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(17);
        mainPanel.add(scroll);
    }
    
    /**
     *  Abre no painel principal a lista de disciplinas/Turmas
     */
    private void showTurmasList(){
        mainPanel.removeAll();
        gradeHorariosPanel = null;
        gradeListPanel = null;
        
        disciplinasTurmasListPanel = new ListPanel(disciplinaList);
        JScrollPane scroll = new JScrollPane(disciplinasTurmasListPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(17);
        
        mainPanel.add(scroll);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    /**
     *  Abre a lista de grades salvas
     */
    private void showGradesList(){
        mainPanel.removeAll();
        gradeHorariosPanel = null;
        disciplinasTurmasListPanel = null;
        gradeListPanel = new ListPanel(gradeList);
        gradeListPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                openGradePopup(me);
            }
        });
        JScrollPane scroll = new JScrollPane(gradeListPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(17);
        mainPanel.add(scroll);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void openGradePopup(MouseEvent evt) {
        GradePopupMenu menu = new GradePopupMenu(null);
        menu.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
        menu.setInvoker(evt.getComponent());
        menu.setVisible(true);
    }
    
    /**
     *  Abre o quadro de horarios de uma grade
     */
    public void showGrade(Grade grade){
        mainPanel.removeAll();
        gradeListPanel = null;
        disciplinasTurmasListPanel = null;
        
        gradeHorariosPanel = new QuadroHorariosPanel(grade);
        JScrollPane scroll = new JScrollPane(gradeHorariosPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(17);
        
        mainPanel.add(scroll);
        mainPanel.revalidate();
        mainPanel.repaint();
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
        turmasMenuPanel = new javax.swing.JPanel();
        turmasLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grade");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        menuPanel.setForeground(java.awt.Color.white);
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new java.awt.GridLayout(1, 4));

        gradesMenuPanel.setBackground(new java.awt.Color(60, 145, 230));

        gradesLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gradesLabel.setForeground(new java.awt.Color(250, 255, 253));
        gradesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradesLabel.setText("Grades");

        javax.swing.GroupLayout gradesMenuPanelLayout = new javax.swing.GroupLayout(gradesMenuPanel);
        gradesMenuPanel.setLayout(gradesMenuPanelLayout);
        gradesMenuPanelLayout.setHorizontalGroup(
            gradesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradesMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        gradesMenuPanelLayout.setVerticalGroup(
            gradesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradesMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(gradesMenuPanel);

        turmasMenuPanel.setBackground(new java.awt.Color(155, 197, 61));

        turmasLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        turmasLabel.setForeground(new java.awt.Color(250, 255, 253));
        turmasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turmasLabel.setText("Turmas");

        javax.swing.GroupLayout turmasMenuPanelLayout = new javax.swing.GroupLayout(turmasMenuPanel);
        turmasMenuPanel.setLayout(turmasMenuPanelLayout);
        turmasMenuPanelLayout.setHorizontalGroup(
            turmasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(turmasMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turmasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        turmasMenuPanelLayout.setVerticalGroup(
            turmasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, turmasMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turmasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
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
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager GradeInteligentePUEntityManager;
    private java.util.List<gradeinteligente.Disciplina> disciplinaList;
    private javax.persistence.Query disciplinaQuery;
    private java.util.List<gradeinteligente.Grade> gradeList;
    private javax.persistence.Query gradeQuery;
    private javax.swing.JLabel gradesLabel;
    private javax.swing.JPanel gradesMenuPanel;
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
