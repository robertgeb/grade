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
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
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
        openTab(mainProfessoresPanel);
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
        menuPanel = new javax.swing.JPanel();
        gradePanel = new javax.swing.JPanel();
        gradeLabel = new javax.swing.JLabel();
        turmasPanel = new javax.swing.JPanel();
        turmasLabel = new javax.swing.JLabel();
        professoresPanel = new javax.swing.JPanel();
        professoresLabel = new javax.swing.JLabel();
        salasPanel = new javax.swing.JPanel();
        salasLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
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
                .addComponent(turmasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
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
                .addComponent(professoresLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
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
                .addComponent(salasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
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

        Serializable newEntityToPersist = null;
        
        switch(getOpenedTab()) {
            case "grade":
                // Criando nova entidade
                Grade newGrade = new Grade();
                newGrade.setNome("Nova Grade");
                // Adicionando a lista que sincroniza com a tabela
                gradeList.add(newGrade);
                // Guardando para ser salva no BD
                newEntityToPersist = (Serializable) newGrade;
                
            case "professores":
                Professor newProfessor = new Professor();
                newProfessor.setNome("Nova Grade");
                newProfessor.setMatricula(9999);
                professorList.add(newProfessor);
                newEntityToPersist = (Serializable) newProfessor;
                break;
            
            case "salas":
                Sala newSala = new Sala();
                newSala.setNumero(22);
                newEntityToPersist = (Serializable) newSala;
                salaList.add(newSala);
                break;
             
            case "turmas":
                Turma newTurma = new Turma();
                newTurma.setNome("IC999");
                newEntityToPersist = (Serializable) newTurma;
                turmaList.add(newTurma);
                break;
                
            default:
                JOptionPane.showMessageDialog(this, "Erro inesperado. Reinicie a aplicação.");
        }
        
        // Persistindo no banco
        GradeInteligentePUEntityManager.getTransaction().begin();
        GradeInteligentePUEntityManager.persist(newEntityToPersist);
        GradeInteligentePUEntityManager.getTransaction().commit();
        
    }//GEN-LAST:event_criarLabelMouseClicked

    private void apagarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apagarLabelMouseClicked
        
        List<?> entityList = null;
        javax.swing.JTable entityTable = null;
        
        // Identificando a tabela aberta
        switch(getOpenedTab()) {
            case "grade":
                entityList = gradeList;
                entityTable = gradeTable;
                break;
            case "professores":
                entityList = professorList;
                entityTable = professoresTable;
                break;
            
            case "salas":
                entityList = salaList;
                entityTable = salasTable;
                break;
             
            case "turmas":
                entityList = turmaList;
                entityTable = turmasTable;
                break;
                
            default:
                JOptionPane.showMessageDialog(this, DEFAULT_ERROR_MESSAGE);
                return;
        }
        
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
    }//GEN-LAST:event_apagarLabelMouseClicked

    private void salvarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarLabelMouseClicked
        
        // Itens da tabela
        List<Serializable> entityList = null;
        
        // Identificando a tabela aberta
        switch(getOpenedTab()) {
            case "grade":
                entityList = (List<Serializable>)(List<?>) gradeList;
                break;
            case "professores":
                entityList = (List<Serializable>)(List<?>) professorList;
                break;
            
            case "salas":
                entityList = (List<Serializable>)(List<?>) salaList;
                break;
             
            case "turmas":
                entityList = (List<Serializable>)(List<?>) turmaList;
                break;
                
            default:
                JOptionPane.showMessageDialog(this, DEFAULT_ERROR_MESSAGE);
                return;
        }
        
        // Percorre a lista de entidades da tabela aberta e persiste as mudanças
        for (Serializable entity: entityList) {
            GradeInteligentePUEntityManager.getTransaction().begin();
            GradeInteligentePUEntityManager.persist(entity);
            GradeInteligentePUEntityManager.getTransaction().commit();
        }
    }//GEN-LAST:event_salvarLabelMouseClicked

    private String getOpenedTab() {
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
    
    private final String DEFAULT_ERROR_MESSAGE = "Erro inesperado, Reinicie a aplicação";
    private final String SELECTED_ROW_ERROR_MESSAGE = "Selecione o item a ser apagado";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager GradeInteligentePUEntityManager;
    private javax.swing.JLabel apagarLabel;
    private javax.swing.JPanel apagarPanel;
    private javax.swing.JLabel criarLabel;
    private javax.swing.JPanel criarPanel;
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
    private javax.swing.JPanel lateralPanel;
    private javax.swing.JPanel mainGradePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainProfessoresPanel;
    private javax.swing.JPanel mainSalasPanel;
    private javax.swing.JPanel mainTurmasPanel;
    private javax.swing.JPanel menuPanel;
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
