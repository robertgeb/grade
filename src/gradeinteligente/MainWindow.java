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
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
        initTableSettings();
        openTab(mainGradePanel);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

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
        gradePanel = new javax.swing.JPanel();
        gradeLabel = new javax.swing.JLabel();
        turmasPanel = new javax.swing.JPanel();
        turmasLabel = new javax.swing.JLabel();
        professoresPanel = new javax.swing.JPanel();
        professoresLabel = new javax.swing.JLabel();
        disciplinaPanel = new javax.swing.JPanel();
        disciplinaLabel = new javax.swing.JLabel();
        salasPanel = new javax.swing.JPanel();
        salasLabel = new javax.swing.JLabel();
        predioPanel = new javax.swing.JPanel();
        predioLabel = new javax.swing.JLabel();
        lateralPanel = new javax.swing.JPanel();
        criarPanel = new javax.swing.JPanel();
        criarLabel = new javax.swing.JLabel();
        apagarPanel = new javax.swing.JPanel();
        apagarLabel = new javax.swing.JLabel();
        salvarPanel = new javax.swing.JPanel();
        salvarLabel = new javax.swing.JLabel();
        visualizarPanel = new javax.swing.JPanel();
        visualizarLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        mainGradePanel = new javax.swing.JPanel();
        gradeTablePanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        gradeTable = new javax.swing.JTable();
        mainTurmasPanel = new javax.swing.JPanel();
        turmasTablePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        turmasTable = new javax.swing.JTable();
        mainProfessoresPanel = new javax.swing.JPanel();
        professoresTablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        professoresTable = new javax.swing.JTable();
        mainSalasPanel = new javax.swing.JPanel();
        salasTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        salasTable = new javax.swing.JTable();
        mainDisciplinaPanel = new javax.swing.JPanel();
        disciplinaTablePanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        disciplinaTable = new javax.swing.JTable();
        mainPredioPanel = new javax.swing.JPanel();
        predioTablePanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        predioTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPanel.setLayout(new java.awt.GridLayout(1, 4));

        gradePanel.setBackground(new java.awt.Color(188, 75, 81));

        gradeLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradeLabel.setText("Grade");
        gradeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout gradePanelLayout = new javax.swing.GroupLayout(gradePanel);
        gradePanel.setLayout(gradePanelLayout);
        gradePanelLayout.setHorizontalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        gradePanelLayout.setVerticalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(gradePanel);

        turmasPanel.setBackground(new java.awt.Color(140, 179, 105));

        turmasLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        turmasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turmasLabel.setText("Turmas");
        turmasLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turmasLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout turmasPanelLayout = new javax.swing.GroupLayout(turmasPanel);
        turmasPanel.setLayout(turmasPanelLayout);
        turmasPanelLayout.setHorizontalGroup(
            turmasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(turmasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turmasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        turmasPanelLayout.setVerticalGroup(
            turmasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(turmasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turmasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(turmasPanel);

        professoresPanel.setBackground(new java.awt.Color(244, 226, 133));

        professoresLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        professoresLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        professoresLabel.setText("Professores");
        professoresLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                professoresLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout professoresPanelLayout = new javax.swing.GroupLayout(professoresPanel);
        professoresPanel.setLayout(professoresPanelLayout);
        professoresPanelLayout.setHorizontalGroup(
            professoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professoresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(professoresLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        professoresPanelLayout.setVerticalGroup(
            professoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(professoresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(professoresLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(professoresPanel);

        disciplinaPanel.setBackground(new java.awt.Color(51, 101, 138));
        disciplinaPanel.setName(""); // NOI18N

        disciplinaLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        disciplinaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disciplinaLabel.setText("Disciplinas");
        disciplinaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disciplinaLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout disciplinaPanelLayout = new javax.swing.GroupLayout(disciplinaPanel);
        disciplinaPanel.setLayout(disciplinaPanelLayout);
        disciplinaPanelLayout.setHorizontalGroup(
            disciplinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disciplinaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(disciplinaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        disciplinaPanelLayout.setVerticalGroup(
            disciplinaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disciplinaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(disciplinaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(disciplinaPanel);

        salasPanel.setBackground(new java.awt.Color(244, 162, 89));

        salasLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        salasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salasLabel.setText("Salas");
        salasLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salasLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout salasPanelLayout = new javax.swing.GroupLayout(salasPanel);
        salasPanel.setLayout(salasPanelLayout);
        salasPanelLayout.setHorizontalGroup(
            salasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        salasPanelLayout.setVerticalGroup(
            salasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(salasPanel);

        predioPanel.setBackground(new java.awt.Color(192, 183, 177));
        predioPanel.setName(""); // NOI18N

        predioLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        predioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        predioLabel.setText("Predios");
        predioLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                predioLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout predioPanelLayout = new javax.swing.GroupLayout(predioPanel);
        predioPanel.setLayout(predioPanelLayout);
        predioPanelLayout.setHorizontalGroup(
            predioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(predioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(predioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        predioPanelLayout.setVerticalGroup(
            predioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(predioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(predioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuPanel.add(predioPanel);

        lateralPanel.setBackground(new java.awt.Color(188, 75, 81));
        lateralPanel.setLayout(new java.awt.GridLayout(10, 1));

        criarPanel.setBackground(new java.awt.Color(188, 75, 81));

        criarLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        criarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        criarLabel.setText("Criar");
        criarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                criarLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout criarPanelLayout = new javax.swing.GroupLayout(criarPanel);
        criarPanel.setLayout(criarPanelLayout);
        criarPanelLayout.setHorizontalGroup(
            criarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(criarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        criarPanelLayout.setVerticalGroup(
            criarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(criarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lateralPanel.add(criarPanel);

        apagarPanel.setBackground(new java.awt.Color(188, 75, 81));

        apagarLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        apagarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apagarLabel.setText("Apagar");
        apagarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apagarLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout apagarPanelLayout = new javax.swing.GroupLayout(apagarPanel);
        apagarPanel.setLayout(apagarPanelLayout);
        apagarPanelLayout.setHorizontalGroup(
            apagarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apagarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apagarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        apagarPanelLayout.setVerticalGroup(
            apagarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apagarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apagarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lateralPanel.add(apagarPanel);

        salvarPanel.setBackground(new java.awt.Color(188, 75, 81));

        salvarLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        salvarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salvarLabel.setText("Salvar");
        salvarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salvarLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout salvarPanelLayout = new javax.swing.GroupLayout(salvarPanel);
        salvarPanel.setLayout(salvarPanelLayout);
        salvarPanelLayout.setHorizontalGroup(
            salvarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salvarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salvarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        salvarPanelLayout.setVerticalGroup(
            salvarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salvarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salvarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lateralPanel.add(salvarPanel);

        visualizarPanel.setBackground(new java.awt.Color(188, 75, 81));

        visualizarLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        visualizarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visualizarLabel.setText("Visualizar");

        javax.swing.GroupLayout visualizarPanelLayout = new javax.swing.GroupLayout(visualizarPanel);
        visualizarPanel.setLayout(visualizarPanelLayout);
        visualizarPanelLayout.setHorizontalGroup(
            visualizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visualizarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        visualizarPanelLayout.setVerticalGroup(
            visualizarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visualizarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lateralPanel.add(visualizarPanel);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new javax.swing.OverlayLayout(mainPanel));

        mainGradePanel.setBackground(new java.awt.Color(188, 75, 81));
        mainGradePanel.setEnabled(false);
        mainGradePanel.setFocusable(false);
        mainGradePanel.setName("grade"); // NOI18N
        mainGradePanel.setLayout(new javax.swing.OverlayLayout(mainGradePanel));

        gradeTablePanel.setLayout(new javax.swing.OverlayLayout(gradeTablePanel));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, gradeList, gradeTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${criacao}"));
        columnBinding.setColumnName("Criacao");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${horarioCollection}"));
        columnBinding.setColumnName("Horarios");
        columnBinding.setColumnClass(java.util.Collection.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(gradeTable);

        gradeTablePanel.add(jScrollPane4);

        mainGradePanel.add(gradeTablePanel);

        mainPanel.add(mainGradePanel);

        mainTurmasPanel.setBackground(new java.awt.Color(140, 179, 105));
        mainTurmasPanel.setEnabled(false);
        mainTurmasPanel.setFocusable(false);
        mainTurmasPanel.setName("turmas"); // NOI18N
        mainTurmasPanel.setLayout(new javax.swing.OverlayLayout(mainTurmasPanel));

        turmasTablePanel.setLayout(new javax.swing.OverlayLayout(turmasTablePanel));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, turmaList, turmasTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${disciplina}"));
        columnBinding.setColumnName("Disciplina");
        columnBinding.setColumnClass(gradeinteligente.Disciplina.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${professor}"));
        columnBinding.setColumnName("Professor");
        columnBinding.setColumnClass(gradeinteligente.Professor.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${horarioCollection}"));
        columnBinding.setColumnName("Horarios");
        columnBinding.setColumnClass(java.util.Collection.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(turmasTable);

        turmasTablePanel.add(jScrollPane3);

        mainTurmasPanel.add(turmasTablePanel);

        mainPanel.add(mainTurmasPanel);

        mainProfessoresPanel.setBackground(new java.awt.Color(244, 226, 133));
        mainProfessoresPanel.setEnabled(false);
        mainProfessoresPanel.setFocusable(false);
        mainProfessoresPanel.setName("professores"); // NOI18N
        mainProfessoresPanel.setLayout(new javax.swing.OverlayLayout(mainProfessoresPanel));

        professoresTablePanel.setLayout(new javax.swing.OverlayLayout(professoresTablePanel));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, professorList, professoresTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${matricula}"));
        columnBinding.setColumnName("Matricula");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${turmaCollection}"));
        columnBinding.setColumnName("Turmas");
        columnBinding.setColumnClass(java.util.Collection.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(professoresTable);
        if (professoresTable.getColumnModel().getColumnCount() > 0) {
            professoresTable.getColumnModel().getColumn(1).setResizable(false);
            professoresTable.getColumnModel().getColumn(2).setResizable(false);
        }

        professoresTablePanel.add(jScrollPane1);

        mainProfessoresPanel.add(professoresTablePanel);

        mainPanel.add(mainProfessoresPanel);

        mainSalasPanel.setBackground(new java.awt.Color(244, 162, 89));
        mainSalasPanel.setName("salas"); // NOI18N
        mainSalasPanel.setLayout(new javax.swing.OverlayLayout(mainSalasPanel));

        salasTablePanel.setLayout(new javax.swing.OverlayLayout(salasTablePanel));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, salaList, salasTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numero}"));
        columnBinding.setColumnName("Numero");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${predio}"));
        columnBinding.setColumnName("Predio");
        columnBinding.setColumnClass(gradeinteligente.Predio.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${horarioCollection}"));
        columnBinding.setColumnName("Horarios");
        columnBinding.setColumnClass(java.util.Collection.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(salasTable);

        salasTablePanel.add(jScrollPane2);

        mainSalasPanel.add(salasTablePanel);

        mainPanel.add(mainSalasPanel);

        mainDisciplinaPanel.setBackground(new java.awt.Color(51, 101, 138));
        mainDisciplinaPanel.setName("disciplina"); // NOI18N
        mainDisciplinaPanel.setLayout(new javax.swing.OverlayLayout(mainDisciplinaPanel));

        disciplinaTablePanel.setName(""); // NOI18N
        disciplinaTablePanel.setLayout(new javax.swing.OverlayLayout(disciplinaTablePanel));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, disciplinaList, disciplinaTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${creditos}"));
        columnBinding.setColumnName("Creditos");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${turmaCollection}"));
        columnBinding.setColumnName("Turmas");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane5.setViewportView(disciplinaTable);

        disciplinaTablePanel.add(jScrollPane5);

        mainDisciplinaPanel.add(disciplinaTablePanel);

        mainPanel.add(mainDisciplinaPanel);

        mainPredioPanel.setBackground(new java.awt.Color(192, 183, 177));
        mainPredioPanel.setName("predio"); // NOI18N
        mainPredioPanel.setLayout(new javax.swing.OverlayLayout(mainPredioPanel));

        predioTablePanel.setName(""); // NOI18N
        predioTablePanel.setLayout(new javax.swing.OverlayLayout(predioTablePanel));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predioList, predioTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${salaCollection}"));
        columnBinding.setColumnName("Sala Collection");
        columnBinding.setColumnClass(java.util.Collection.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane6.setViewportView(predioTable);

        predioTablePanel.add(jScrollPane6);

        mainPredioPanel.add(predioTablePanel);

        mainPanel.add(mainPredioPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lateralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lateralPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        bindingGroup.bind();

        pack();
    }//GEN-END:initComponents

    private void gradeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeLabelMouseClicked
        openTab(mainGradePanel);
    }//GEN-LAST:event_gradeLabelMouseClicked

    private void turmasLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turmasLabelMouseClicked
        openTab(mainTurmasPanel);
    }//GEN-LAST:event_turmasLabelMouseClicked

    private void professoresLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_professoresLabelMouseClicked
        openTab(mainProfessoresPanel);
    }//GEN-LAST:event_professoresLabelMouseClicked

    private void salasLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salasLabelMouseClicked
        openTab(mainSalasPanel);
    }//GEN-LAST:event_salasLabelMouseClicked

    private void criarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_criarLabelMouseClicked

        Serializable newEntityToPersist = getSelectedEntity();
        List<Serializable> entityList = (List<Serializable>)(List<?>) getSelectedList();
        String entityName = getOpenedTabName();
        
        entityList.add(newEntityToPersist);
        
        if(newEntityToPersist == null || entityList == null){
            JOptionPane.showMessageDialog(this, DEFAULT_ERROR_MESSAGE);
            return;
        }
            
        
        // Persistindo no banco
        GradeInteligentePUEntityManager.getTransaction().begin();
        GradeInteligentePUEntityManager.persist(newEntityToPersist);
        GradeInteligentePUEntityManager.getTransaction().commit();
        setSaved(entityName);
    }//GEN-LAST:event_criarLabelMouseClicked

    private void apagarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apagarLabelMouseClicked
        
        List<?> entityList = getSelectedList();
        javax.swing.JTable entityTable = getSelectedTable();
        String entityName = getOpenedTabName();
        
        if(entityList == null || entityTable == null){
            JOptionPane.showMessageDialog(this, DEFAULT_ERROR_MESSAGE);
            return;
        }
        
        // Identifica a linha selecionada para ser salva
        int indexRow = entityTable.getSelectedRow();
        if (indexRow == -1){
            JOptionPane.showMessageDialog(this, SELECTED_ROW_ERROR_MESSAGE);
            return;
        }
        
        // Removendo a linha
        Serializable entityRemoved = (Serializable) entityList.remove(indexRow);
        // Removendo do BD
        GradeInteligentePUEntityManager.getTransaction().begin();
        GradeInteligentePUEntityManager.remove(entityRemoved);
        GradeInteligentePUEntityManager.getTransaction().commit();
        setSaved(entityName);
    }//GEN-LAST:event_apagarLabelMouseClicked

    private void salvarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarLabelMouseClicked
        
        // Itens da tabela
        List<Serializable> entityList = (List<Serializable>)(List<?>) getSelectedList();
        String tabOpened = getOpenedTabName();
        
        if(entityList == null){
            JOptionPane.showMessageDialog(this, DEFAULT_ERROR_MESSAGE);
            return;
        }
        
        // Percorre a lista de entidades da tabela aberta e persiste as mudanças
        for (Serializable entity: entityList) {
            GradeInteligentePUEntityManager.getTransaction().begin();
            GradeInteligentePUEntityManager.persist(entity);
            GradeInteligentePUEntityManager.getTransaction().commit();
        }
        
        setSaved(tabOpened);
        
        initTableSettings();
        
    }//GEN-LAST:event_salvarLabelMouseClicked

    private void disciplinaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disciplinaLabelMouseClicked
        openTab(mainDisciplinaPanel);
    }//GEN-LAST:event_disciplinaLabelMouseClicked

    private void predioLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_predioLabelMouseClicked
        openTab(mainPredioPanel);
    }//GEN-LAST:event_predioLabelMouseClicked

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
                return gradeLabel;
                
            case PROFESSOR:
                return professoresLabel;
            
            case SALA:
                return salasLabel;
             
            case TURMA:
                return turmasLabel;
                
            case DISCIPLINA:
                return disciplinaLabel;
                
            case PREDIO:
                return predioLabel;    
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
    
    private JTable getSelectedTable() {
        switch(getOpenedTabName()) {
            case GRADE:
                return gradeTable;
                
            case PROFESSOR:
                return professoresTable;
            
            case SALA:
                return salasTable;
             
            case TURMA:
                return turmasTable;
            
            case DISCIPLINA:
                return disciplinaTable;
                
            case PREDIO:
                return predioTable;
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
    
    private void initTableSettings() {
        
        // Configurando caixas de seleção
        JComboBox disciplinaBox = new JComboBox();
        JComboBox professorBox = new JComboBox();
        JComboBox predioBox = new JComboBox();
        
        for(Disciplina disciplina: disciplinaList) {
            disciplinaBox.addItem(disciplina);
        }
        for(Professor professor: professorList) {
            professorBox.addItem(professor);
        }
        
        for(Predio predio: predioList) {
            predioBox.addItem(predio);
        }
        
        turmasTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(disciplinaBox));
        turmasTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(professorBox));
        salasTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(predioBox));
         
        
        // Configurando eventos de modificação
        gradeTable.putClientProperty("terminateEditOnFocusLost", true);
        professoresTable.putClientProperty("terminateEditOnFocusLost", true);
        salasTable.putClientProperty("terminateEditOnFocusLost", true);
        turmasTable.putClientProperty("terminateEditOnFocusLost", true);
        disciplinaTable.putClientProperty("terminateEditOnFocusLost", true);
        predioTable.putClientProperty("terminateEditOnFocusLost", true);
        
        gradeTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                setToSave(GRADE);
            }
        });
        
        professoresTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                setToSave(PROFESSOR);
            }
        });
        
        salasTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                setToSave(SALA);
            }
        });
        
        turmasTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                setToSave(TURMA);
            }
        });
        
        disciplinaTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                setToSave(DISCIPLINA);
            }
        });
        
        predioTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                setToSave(PREDIO);
            }
        });
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
      
    private void openTab(javax.swing.JPanel panelToOpen) {
        // Deabilitando e deixando todos os jPanels invisiveis
        for(Component panel : mainPanel.getComponents() ) {   
            panel.setEnabled(false);
            panel.setFocusable(false);
            panel.setVisible(false);
        }
        // Habilitando o jPanel selecionado
        panelToOpen.setEnabled(true);
        panelToOpen.setFocusable(true);
        panelToOpen.setVisible(true);
        // Mudando cor da barra lateral
        lateralPanel.setBackground(panelToOpen.getBackground());
        for(Component itemLateral : lateralPanel.getComponents() ) {
            // Mudando cor de todos os itens da barra Lateral
            itemLateral.setBackground(panelToOpen.getBackground());
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
    private final String SELECTED_ROW_ERROR_MESSAGE = "Selecione o item a ser apagado";
    private Set<String> toSaveList = new HashSet<String>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager GradeInteligentePUEntityManager;
    private javax.swing.JLabel apagarLabel;
    private javax.swing.JPanel apagarPanel;
    private javax.swing.JLabel criarLabel;
    private javax.swing.JPanel criarPanel;
    private javax.swing.JLabel disciplinaLabel;
    private java.util.List<gradeinteligente.Disciplina> disciplinaList;
    private javax.swing.JPanel disciplinaPanel;
    private javax.persistence.Query disciplinaQuery;
    private javax.swing.JTable disciplinaTable;
    private javax.swing.JPanel disciplinaTablePanel;
    private javax.swing.JLabel gradeLabel;
    private java.util.List<gradeinteligente.Grade> gradeList;
    private javax.swing.JPanel gradePanel;
    private javax.persistence.Query gradeQuery;
    private javax.swing.JTable gradeTable;
    private javax.swing.JPanel gradeTablePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel lateralPanel;
    private javax.swing.JPanel mainDisciplinaPanel;
    private javax.swing.JPanel mainGradePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPredioPanel;
    private javax.swing.JPanel mainProfessoresPanel;
    private javax.swing.JPanel mainSalasPanel;
    private javax.swing.JPanel mainTurmasPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel predioLabel;
    private java.util.List<gradeinteligente.Predio> predioList;
    private javax.swing.JPanel predioPanel;
    private javax.persistence.Query predioQuery;
    private javax.swing.JTable predioTable;
    private javax.swing.JPanel predioTablePanel;
    private java.util.List<gradeinteligente.Professor> professorList;
    private javax.persistence.Query professorQuery;
    private javax.swing.JLabel professoresLabel;
    private javax.swing.JPanel professoresPanel;
    private javax.swing.JTable professoresTable;
    private javax.swing.JPanel professoresTablePanel;
    private java.util.List<gradeinteligente.Sala> salaList;
    private javax.persistence.Query salaQuery;
    private javax.swing.JLabel salasLabel;
    private javax.swing.JPanel salasPanel;
    private javax.swing.JTable salasTable;
    private javax.swing.JPanel salasTablePanel;
    private javax.swing.JLabel salvarLabel;
    private javax.swing.JPanel salvarPanel;
    private java.util.List<gradeinteligente.Turma> turmaList;
    private javax.persistence.Query turmaQuery;
    private javax.swing.JLabel turmasLabel;
    private javax.swing.JPanel turmasPanel;
    private javax.swing.JTable turmasTable;
    private javax.swing.JPanel turmasTablePanel;
    private javax.swing.JLabel visualizarLabel;
    private javax.swing.JPanel visualizarPanel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
