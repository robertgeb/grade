/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import org.jgap.FitnessFunction;
import org.jgap.Chromosome;
import org.jgap.Gene;
import org.jgap.IChromosome;


/**
 *
 * @author robert
 */
public class GradeFitnessFunction extends FitnessFunction{

    private final double valorAlvo = 0.8;
    private Grade grade;

    public GradeFitnessFunction(Grade grade) {
        this.grade = grade;
    }
    
    
    
    @Override
    protected double evaluate(IChromosome chromosome) {
        double value = 1;
        int sum = 0;
        for(Gene gene: chromosome.getGenes()){
            value += ((Horario)gene.getAllele()).getValor();
            sum++;
        }
        value /= sum;
        return value;
    }
    
}
