/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.jgap.Configuration;
import org.jgap.impl.DefaultConfiguration;

/**
 *
 * @author robert
 */
public class GeradorGrade {
    
    private Grade grade;
    private List<Turma> listaTurma;
    private EntityManager entityManager;
    private Configuration conf;
    private ArrayList<HorarioGene> geneList;

    public GeradorGrade(Grade grade, List<Turma> listaTurma, EntityManager entityManager) {
        this.grade = grade;
        this.listaTurma = listaTurma;
        this.entityManager = entityManager;
        configAlgGen();
        gerarHorarios();
    }
    
    private void gerarHorarios(){
        // Para cada turma a ser criado horario
        for(Turma turma: listaTurma){
            // Identifica o numero de créditos
            int creditos = turma.getDisciplina().getCreditos();
            for(int i=0; i < creditos; i++){
                // Cria horarios de acordo com o número de creditos
                Horario novoHorario = new Horario();
                novoHorario.setGrade(grade);
                novoHorario.setTurma(turma);
                // Persiste no banco
                entityManager.getTransaction().begin();
                entityManager.persist(novoHorario);
                entityManager.getTransaction().commit();
                //geneList.add(new HorarioGene());;
                
            }
        }
    }
    
    private void configAlgGen() {
        conf = new DefaultConfiguration();
        
    }
    
    public Grade getGradeGerada() {
        return grade;
    }
    
}
