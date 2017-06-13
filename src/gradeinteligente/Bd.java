/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author robert
 */
public class Bd {
    
    private Connection connection = null;
    private String databaseUser = "root";
    private String databasePassword = "";
    
    Bd() {
        connect();
    }
    
    
    private void connect(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grade", databaseUser, databasePassword);
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            if(ex.getErrorCode() == 1049){  // Se banco de dados não existe
                createDatabase();
                connect();
            }
        }
    }
    
    private void disconnect() {
        try {
            connection.close();
            connection = null;
        }  catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // TODO Tratar erros do banco de dados
        }
    }
    
    public void update(Model model) {
        try {
                Statement s = null;
                s = connection.createStatement();
                s.executeUpdate(model.toSqlUpdate());
                disconnect();

            } catch(SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                // TODO Tratar erros do banco de dados
            }
    }
    
    public int insert(Model model) {
        try {
                Statement s = null;
                s = connection.createStatement();
                s.executeUpdate(model.toSqlInsert(), Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = s.getGeneratedKeys();
                if(rs.next())
                {
                    disconnect();
                    return rs.getInt(1);
                }

            } catch(SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                // TODO Tratar erros do banco de dados
            }
        return 0;
    }
    
    public Model find(Model model) {
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(model.toSqlFind());
            if (rs.next()) {
                model.setAttributesFromResultSet(rs);
                disconnect();
                return model;
            }
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // TODO Tratar erros do banco de dados
        }
        
        return null;
    }
    
    
    private void createDatabase() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", databaseUser, databasePassword);
            Statement stm = connection.createStatement();
            int result = stm.executeUpdate("CREATE DATABASE grade");
            disconnect();
            connect();
            createTables();
            disconnect();
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // TODO Tratar erros do banco de dados
        }
    }
    
    private void createTables() {
        
        try{
            Statement stmt = null;

            stmt = connection.createStatement();

            String professorTableSQL = "CREATE TABLE professor " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " nome VARCHAR(255), " + 
                        " matricula INTEGER, " + 
                        " PRIMARY KEY ( id ))"; 

            String disciplinaTableSQL = "CREATE TABLE disciplina " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " nome VARCHAR(255), " + 
                        " creditos INTEGER, " + 
                        " PRIMARY KEY ( id ))"; 

            String predioTableSQL = "CREATE TABLE predio " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " nome VARCHAR(255), " +
                        " PRIMARY KEY ( id ))";
            
            String salaTableSQL = "CREATE TABLE sala " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " numero INTEGER, " + 
                        " predio INTEGER, " +
                        " PRIMARY KEY ( id )," +
                        "FOREIGN KEY (predio) REFERENCES predio(id))";  
            
            String gradeTableSQL = "CREATE TABLE grade " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " nome VARCHAR(255), " + 
                        " criacao DATETIME, " + 
                        " PRIMARY KEY ( id ))"; 

            String turmaTableSQL = "CREATE TABLE turma " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " nome VARCHAR(5), " + 
                        " disciplina INTEGER, " + 
                        " professor INTEGER, " + 
                        " PRIMARY KEY ( id )," +
                        "FOREIGN KEY (disciplina) REFERENCES disciplina(id)," +
                        "FOREIGN KEY (professor) REFERENCES professor(id))";  

            
            String horarioTableSQL = "CREATE TABLE horario " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " turma INTEGER, " + 
                        " sala INTEGER, " +
                        " dia INTEGER, " + 
                        " hora TIME, " + 
                        " grade INTEGER, " +
                        " PRIMARY KEY ( id )," +
                        "FOREIGN KEY (sala) REFERENCES sala(id)," +
                        "FOREIGN KEY (turma) REFERENCES turma(id)," +
                        "FOREIGN KEY (grade) REFERENCES grade(id))";  

            
            stmt.addBatch(professorTableSQL);
            stmt.addBatch(disciplinaTableSQL);
            stmt.addBatch(predioTableSQL);
            stmt.addBatch(salaTableSQL);
            stmt.addBatch(gradeTableSQL);
            stmt.addBatch(turmaTableSQL);
            stmt.addBatch(horarioTableSQL);
            stmt.executeBatch();
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // TODO Tratar erros do banco de dados
        }
    }
    
}
