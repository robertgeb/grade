/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.sql.ResultSet;

/**
 *
 * @author robert
 */
public interface Model {
    
    public void save();
    
    public String toSqlUpdate();
    
    public String toSqlInsert();
    
    public String toSqlFind();
    
    public String toSqlFindAll();
    
    public Model setAttributesFromResultSet(ResultSet rs);
}
