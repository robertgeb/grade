/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author robert
 */
public class QuadroHorariosPanel extends javax.swing.JPanel {

    final int TURMA_WIDTH = 70;
    final int TURMA_HEIGHT = 60;
    
    private Grade grade;
    private JLabel[] diaLabelList = new JLabel[6];
    private int linhasPorDia[] = {0,0,0,0,0,0};
    
    /**
     * Creates new form GradeHorariosPanel
     */
    public QuadroHorariosPanel(Grade grade) {
        initComponents();
        this.grade = grade;
        initLabels();
        initHorariosPanels();
    }

    private void initLabels(){
        // Nome da grade no topo
        nomeGradeLabel.setText(grade.getNome());
        // Configurando labels dos dias da semana
        diaLabelList[0] = new JLabel("Seg");
        diaLabelList[1] = new JLabel("Ter");
        diaLabelList[2] = new JLabel("Qua");
        diaLabelList[3] = new JLabel("Qui");
        diaLabelList[4] = new JLabel("Sex");
        diaLabelList[5] = new JLabel("Sáb");
        
        for (int i = 0; i < 6; i++) {
            horariosPanel.add(diaLabelList[i]);
            // Posicionando cada label
            diaLabelList[i].setBounds(0, i*TURMA_HEIGHT, TURMA_WIDTH, TURMA_HEIGHT);
        }
    }
    
    private void initHorariosPanels(){
        Collection<Horario> horarios = grade.getHorarioCollection();
        // Percorre todos os horarios da grade
        for (Horario horario : horarios) {
            createHorarioPanel(horario);
        }
        this.revalidate();
        this.repaint();
    }
    
    private void createHorarioPanel(Horario horario){
        // Cria JPanel para o horario/turma
        HorarioPanel horarioPanel = new HorarioPanel(horario);
        // Ajusta a altura do quadro caso haja outra turma na mesmoa hora
        ajustDiaHeight(horario.getDia(), horarioPanel.getHoraNormalizada());
        // Configura a posição do horario no quadro
        int posY = posYByDia(horario.getDia());
        int posX = posXByHora(horarioPanel.getHoraNormalizada());
        horarioPanel.setBounds(posX, posY, TURMA_WIDTH*2, TURMA_HEIGHT);
        // Adiciona ao quadro
        horariosPanel.add(horarioPanel);
        
    }
    private int posYByDia(int dia){
        // Quantidade de linhas no dia * Altura padrão + a linha referente ao dia * Altura padrão
        return linhasPorDia[dia]*TURMA_HEIGHT+dia*TURMA_HEIGHT;
    }
    
    private int posXByHora(int hora){
        int x = 0;
        // Pulando horario de almoço
        if(hora > 12)
            x = (hora-9)*TURMA_WIDTH;// Hora normalizada * Largura padrão
        else
            x = (hora-8)*TURMA_WIDTH;
        
        return x+TURMA_WIDTH; // Pos do elem + Largura padrão para descontar a Label do nome do dia
    }
    
    // Verifica se há outra turma no mesmo horario e dia para ajustar a altura do container
    private void ajustDiaHeight(int dia, int hora){
        Component[] turmasInseridas = horariosPanel.getComponents();
        // Percorre todos os elementos inseridos
        for (Component turmaInserida : turmasInseridas) {
            if(turmaInserida instanceof HorarioPanel){ // Verifica se o Component é um horario(Não uma Label)
                if(((HorarioPanel)turmaInserida).getHoraNormalizada() == hora && ((HorarioPanel)turmaInserida).getDia() == dia){
                    // Se for uma hora igual a de algum elemento inserido
                    linhasPorDia[dia]++; // Soma uma linha ao dia
                    sumComponentsHeight(dia); // Ajusta posição e altura dos elementos abaixo do dia
                    break;
                }
            }       
        }
    }
    
    private void sumComponentsHeight(int dia){
        // Ajusta altura geral do quadro
        horariosPanel.setSize(horariosPanel.getSize().width, horariosPanel.getSize().height + TURMA_HEIGHT);
        // Percorre todos os elementos do quadro
        Component[] turmasInseridas = horariosPanel.getComponents();
        for (Component turmaInserida : turmasInseridas) {
            if(turmaInserida instanceof HorarioPanel && ((HorarioPanel)turmaInserida).getDia() > dia){
                // Se tiver uma posição abaixo do dia em questão
                // Ajusta posição de cada elemento
                turmaInserida.setLocation(turmaInserida.getLocation().x, turmaInserida.getLocation().y + TURMA_HEIGHT);
            }       
        }
        // Ajusta pos da label
        for (int i = dia+1; i < 6; i++) {
            diaLabelList[i].setLocation(0, diaLabelList[i].getLocation().y+TURMA_HEIGHT);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        nomeGradeLabel = new javax.swing.JLabel();
        quadroPanel = new javax.swing.JPanel();
        linhaHorasLabel = new javax.swing.JLabel();
        horariosPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        nomeGradeLabel.setText("Nome Grade");

        quadroPanel.setBackground(new java.awt.Color(255, 255, 255));

        linhaHorasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linhaHorasLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gradeinteligente/images/linhaHoras.png"))); // NOI18N

        horariosPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout horariosPanelLayout = new javax.swing.GroupLayout(horariosPanel);
        horariosPanel.setLayout(horariosPanelLayout);
        horariosPanelLayout.setHorizontalGroup(
            horariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
        );
        horariosPanelLayout.setVerticalGroup(
            horariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout quadroPanelLayout = new javax.swing.GroupLayout(quadroPanel);
        quadroPanel.setLayout(quadroPanelLayout);
        quadroPanelLayout.setHorizontalGroup(
            quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadroPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(linhaHorasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        quadroPanelLayout.setVerticalGroup(
            quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(linhaHorasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horariosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(449, Short.MAX_VALUE)
                .addComponent(nomeGradeLabel)
                .addContainerGap(450, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(quadroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomeGradeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quadroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel horariosPanel;
    private javax.swing.JLabel linhaHorasLabel;
    private javax.swing.JLabel nomeGradeLabel;
    private javax.swing.JPanel quadroPanel;
    // End of variables declaration//GEN-END:variables
}
