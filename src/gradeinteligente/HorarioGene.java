/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;


import java.util.ArrayList;
import java.util.Collection;
import org.jgap.*;

/**
 *
 * @author robert
 */
public class HorarioGene extends BaseGene implements Gene, java.io.Serializable {

    private Horario horario;
    private Grade grade;
    private double valorGene;
    
    public HorarioGene(Configuration a_configuration, Horario horario) throws InvalidConfigurationException {
        super(a_configuration);
        this.horario = horario;
        this.grade = horario.getGrade();
        this.valorGene = horario.getValor();
        System.out.println(valorGene);
    }

    
    
    @Override
    protected Object getInternalValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Gene newGeneInternal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAllele(Object horario) {
        this.horario = (Horario) horario;
    }
    
    @Override
    public HorarioGene getAllele() {
        return this;
    }

    @Override
    public String getPersistentRepresentation() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueFromPersistentRepresentation(String a_representation) throws UnsupportedOperationException, UnsupportedRepresentationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setToRandomValue(RandomGenerator a_numberGenerator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void applyMutation(int index, double a_percentage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean equals(Object otherHorarioGene) {
        return otherHorarioGene instanceof HorarioGene && 
               compareTo( otherHorarioGene ) == 0;
    }
    
    @Override
    public int hashCode()
    {
        return 0;
    }
}
