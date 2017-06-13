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
    
    public String toSqlUpdate();
    
    public String toSqlInsert();
    
    public String toSqlFind();
    
    public void setAttributesFromResultSet(ResultSet rs);
}
