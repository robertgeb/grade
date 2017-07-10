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
import javax.swing.BorderFactory;
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
    private JLabel[] diaLabelList;
    private JLabel[] divDiaLabelList;
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
        diaLabelList = new JLabel[6];
        diaLabelList[0] = new JLabel("Seg");
        diaLabelList[1] = new JLabel("Ter");
        diaLabelList[2] = new JLabel("Qua");
        diaLabelList[3] = new JLabel("Qui");
        diaLabelList[4] = new JLabel("Sex");
        diaLabelList[5] = new JLabel("Sáb");
        divDiaLabelList = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            divDiaLabelList[i] = new JLabel("");
            divDiaLabelList[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
            
            horariosPanel.add(divDiaLabelList[i]);
            horariosPanel.add(diaLabelList[i]);
            // Posicionando cada label
            divDiaLabelList[i].setBounds(0, (i+1)*TURMA_HEIGHT, TURMA_WIDTH*13, 1);
            diaLabelList[i].setBounds(0, i*TURMA_HEIGHT, TURMA_WIDTH, TURMA_HEIGHT);
        }
        divDiaLabelList[5].setBorder(null);
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
        int posY = posYByDia(horario.getDia())+1;
        int posX = posXByHora(horarioPanel.getHoraNormalizada());
        horarioPanel.setBounds(posX, posY, TURMA_WIDTH*2, TURMA_HEIGHT-1);
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
            divDiaLabelList[i].setLocation(0, divDiaLabelList[i].getLocation().y+TURMA_HEIGHT);
        }
        divDiaLabelList[dia].setLocation(0, divDiaLabelList[dia].getLocation().y+TURMA_HEIGHT);
        diaLabelList[dia].setLocation(0, diaLabelList[dia].getLocation().y+(TURMA_HEIGHT)/2);
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
        h0Label = new javax.swing.JLabel();
        h0Label1 = new javax.swing.JLabel();
        h0Label2 = new javax.swing.JLabel();
        h0Label3 = new javax.swing.JLabel();
        h0Label5 = new javax.swing.JLabel();
        h0Label6 = new javax.swing.JLabel();
        h0Label7 = new javax.swing.JLabel();
        h0Label4 = new javax.swing.JLabel();
        h0Label8 = new javax.swing.JLabel();
        h0Label9 = new javax.swing.JLabel();
        h0Label10 = new javax.swing.JLabel();
        h0Label11 = new javax.swing.JLabel();
        h0Label12 = new javax.swing.JLabel();

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
            .addGap(0, 315, Short.MAX_VALUE)
        );

        h0Label.setText("8:00");

        h0Label1.setText("9:00");

        h0Label2.setText("10:00");

        h0Label3.setText("11:00");

        h0Label5.setText("13:00");

        h0Label6.setText("14:00");

        h0Label7.setText("15:00");

        h0Label4.setText("16:00");

        h0Label8.setText("17:00");

        h0Label9.setText("18:00");

        h0Label10.setText("19:00");

        h0Label11.setText("20:00");

        h0Label12.setText("21:00");

        javax.swing.GroupLayout quadroPanelLayout = new javax.swing.GroupLayout(quadroPanel);
        quadroPanel.setLayout(quadroPanelLayout);
        quadroPanelLayout.setHorizontalGroup(
            quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(horariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(quadroPanelLayout.createSequentialGroup()
                            .addComponent(h0Label)
                            .addGap(45, 45, 45)
                            .addComponent(h0Label1)
                            .addGap(35, 35, 35)
                            .addComponent(h0Label2)
                            .addGap(36, 36, 36)
                            .addComponent(h0Label3)
                            .addGap(35, 35, 35)
                            .addComponent(h0Label5)
                            .addGap(32, 32, 32)
                            .addComponent(h0Label6)
                            .addGap(37, 37, 37)
                            .addComponent(h0Label7)
                            .addGap(29, 29, 29)
                            .addComponent(h0Label4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h0Label8)
                            .addGap(18, 18, 18)
                            .addComponent(h0Label9)
                            .addGap(45, 45, 45)
                            .addComponent(h0Label10)
                            .addGap(41, 41, 41)
                            .addComponent(h0Label11)
                            .addGap(27, 27, 27)
                            .addComponent(h0Label12))
                        .addComponent(linhaHorasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        quadroPanelLayout.setVerticalGroup(
            quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadroPanelLayout.createSequentialGroup()
                .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(h0Label2)
                            .addComponent(h0Label3))
                        .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(h0Label)
                            .addComponent(h0Label1))
                        .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(h0Label5)
                            .addComponent(h0Label6))
                        .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(h0Label7)
                            .addComponent(h0Label4)))
                    .addGroup(quadroPanelLayout.createSequentialGroup()
                        .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(h0Label8)
                            .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(h0Label9)
                                .addComponent(h0Label10))
                            .addGroup(quadroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(h0Label11)
                                .addComponent(h0Label12)))
                        .addGap(0, 0, 0)))
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
                .addContainerGap(486, Short.MAX_VALUE)
                .addComponent(nomeGradeLabel)
                .addContainerGap(487, Short.MAX_VALUE))
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
    private javax.swing.JLabel h0Label;
    private javax.swing.JLabel h0Label1;
    private javax.swing.JLabel h0Label10;
    private javax.swing.JLabel h0Label11;
    private javax.swing.JLabel h0Label12;
    private javax.swing.JLabel h0Label2;
    private javax.swing.JLabel h0Label3;
    private javax.swing.JLabel h0Label4;
    private javax.swing.JLabel h0Label5;
    private javax.swing.JLabel h0Label6;
    private javax.swing.JLabel h0Label7;
    private javax.swing.JLabel h0Label8;
    private javax.swing.JLabel h0Label9;
    private javax.swing.JPanel horariosPanel;
    private javax.swing.JLabel linhaHorasLabel;
    private javax.swing.JLabel nomeGradeLabel;
    private javax.swing.JPanel quadroPanel;
    // End of variables declaration//GEN-END:variables
}
