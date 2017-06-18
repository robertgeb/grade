/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.BorderFactory;

/**
 *
 * @author robert
 */
public class HorariosPanel extends javax.swing.JPanel {

    /**
     * Creates new form HorariosPanel
     */
    public HorariosPanel(Grade grade) {
        setGrade(grade);
        initComponents();
        
        horarioTurmasPanel.setLayout(null);
        diaLabelList = new String[]{"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        diaAtual = 1;
        initGrade();
    }

    private void initGrade() {
        // Lista de salas únicas
        salas = new LinkedHashSet<Sala>();
        
        // Percorre os horarios dessa grade
        for(Horario horario: grade.getHorarioCollection()) {
            if(horario.getDia() != diaAtual)
                continue;
            if(salas.add(horario.getSala())){ // Se for uma sala ainda não identificada
                createSalaLabel(horario.getSala()); // Cria a nova label
            }
            
            // Cria um painel pra turma do horario
            HorarioTurmaPanel turma = new HorarioTurmaPanel();
            turma.setTurma(horario.getTurma().toString());
            turma.setProfessor(horario.getTurma().getProfessor().toString());
            // Configurando posição e tamanho
            turma.setBounds(
                    timeToPosition(horario.getHora()), // A hora define a posição horizontal
                    salaToPosition(horario.getSala()), // A sala define a posição vertical
                    TURMA_PANEL_WIDTH, 
                    TURMA_PANEL_HEIGTH
            );
            turma.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            // Adicionando ao quadro
            horarioTurmasPanel.add(turma);
        }  
    }
    
    private void createSalaLabel(Sala sala) {
        HorariosSalaPanel salaPanel = new HorariosSalaPanel(sala);
        salaPanel.setBounds(0, salaToPosition(sala), SALA_PANEL_WIDTH, SALA_PANEL_HEIGTH);
        horarioSalasPanel.add(salaPanel);
    }
    
    public void setGrade(Grade grade) {
        this.grade = grade;        
    }
    
    private int timeToPosition(Date hora) {
        int horaInt = Integer.parseInt(hora.toString().substring(11, 13));
        
        return (horaInt - 8)*TURMA_PANEL_WIDTH;
    }
    
    private int salaToPosition(Sala sala) {
        int index = 0;
        for(Sala salaListada: salas){
            if(sala.equals(salaListada))
                break;
            index++;
        }
        
        return index * TURMA_PANEL_HEIGTH;
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        diaLabel = new javax.swing.JLabel();
        linhaHorasLabel = new javax.swing.JLabel();
        hora8Label = new javax.swing.JLabel();
        hora9Label = new javax.swing.JLabel();
        hora11Label = new javax.swing.JLabel();
        hora10Label = new javax.swing.JLabel();
        hora12Label = new javax.swing.JLabel();
        hora13Label = new javax.swing.JLabel();
        hora19Label = new javax.swing.JLabel();
        hora20Label = new javax.swing.JLabel();
        hora14Label = new javax.swing.JLabel();
        hora15Label = new javax.swing.JLabel();
        hora16Label = new javax.swing.JLabel();
        hora18Label = new javax.swing.JLabel();
        hora21Label = new javax.swing.JLabel();
        horarioTurmasPanel = new javax.swing.JPanel();
        horarioSalasPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 249, 249));

        diaLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        diaLabel.setText("Segunda");

        linhaHorasLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gradeinteligente/linhaHoras.png"))); // NOI18N

        hora8Label.setText("8:00");

        hora9Label.setText("9:00");

        hora11Label.setText("11:00");

        hora10Label.setText("10:00");

        hora12Label.setText("12:00");

        hora13Label.setText("13:00");

        hora19Label.setText("19:00");

        hora20Label.setText("20:00");

        hora14Label.setText("14:00");

        hora15Label.setText("15:00");

        hora16Label.setText("16:00");

        hora18Label.setText("18:00");

        hora21Label.setText("21:00");

        horarioTurmasPanel.setOpaque(false);
        horarioTurmasPanel.setLayout(new javax.swing.BoxLayout(horarioTurmasPanel, javax.swing.BoxLayout.LINE_AXIS));

        horarioSalasPanel.setOpaque(false);

        javax.swing.GroupLayout horarioSalasPanelLayout = new javax.swing.GroupLayout(horarioSalasPanel);
        horarioSalasPanel.setLayout(horarioSalasPanelLayout);
        horarioSalasPanelLayout.setHorizontalGroup(
            horarioSalasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        horarioSalasPanelLayout.setVerticalGroup(
            horarioSalasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(horarioSalasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(horarioTurmasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(linhaHorasLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(hora8Label)
                                .addGap(41, 41, 41)
                                .addComponent(hora9Label)
                                .addGap(43, 43, 43)
                                .addComponent(hora10Label)
                                .addGap(30, 30, 30)
                                .addComponent(hora11Label)
                                .addGap(40, 40, 40)
                                .addComponent(hora12Label)
                                .addGap(29, 29, 29)
                                .addComponent(hora13Label)
                                .addGap(34, 34, 34)
                                .addComponent(hora14Label)
                                .addGap(34, 34, 34)
                                .addComponent(hora15Label)
                                .addGap(34, 34, 34)
                                .addComponent(hora16Label)
                                .addGap(34, 34, 34)
                                .addComponent(hora18Label)
                                .addGap(32, 32, 32)
                                .addComponent(hora19Label)
                                .addGap(35, 35, 35)
                                .addComponent(hora20Label)
                                .addGap(33, 33, 33)
                                .addComponent(hora21Label)))
                        .addComponent(diaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(diaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hora8Label)
                    .addComponent(hora9Label)
                    .addComponent(hora10Label)
                    .addComponent(hora11Label)
                    .addComponent(hora12Label)
                    .addComponent(hora13Label)
                    .addComponent(hora14Label)
                    .addComponent(hora15Label)
                    .addComponent(hora16Label)
                    .addComponent(hora18Label)
                    .addComponent(hora19Label)
                    .addComponent(hora20Label)
                    .addComponent(hora21Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linhaHorasLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horarioSalasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(horarioTurmasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private String[] diaLabelList;
    private int diaAtual;
    private Set<Sala> salas;
    private Grade grade;
    private int TURMA_PANEL_HEIGTH = 40;
    private int TURMA_PANEL_WIDTH = 72;
    private int SALA_PANEL_WIDTH = 72;
    private int SALA_PANEL_HEIGTH = 40;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel diaLabel;
    private javax.swing.JLabel hora10Label;
    private javax.swing.JLabel hora11Label;
    private javax.swing.JLabel hora12Label;
    private javax.swing.JLabel hora13Label;
    private javax.swing.JLabel hora14Label;
    private javax.swing.JLabel hora15Label;
    private javax.swing.JLabel hora16Label;
    private javax.swing.JLabel hora18Label;
    private javax.swing.JLabel hora19Label;
    private javax.swing.JLabel hora20Label;
    private javax.swing.JLabel hora21Label;
    private javax.swing.JLabel hora8Label;
    private javax.swing.JLabel hora9Label;
    private javax.swing.JPanel horarioSalasPanel;
    private javax.swing.JPanel horarioTurmasPanel;
    private javax.swing.JLabel linhaHorasLabel;
    // End of variables declaration//GEN-END:variables
}
