/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeinteligente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author robert
 */
public class Bd {
    private Connection connection = null;
    Bd() {
        connect();
        
    }
    
    private void connect(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grade", "root", "");
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            if(ex.getErrorCode() == 1049){  // Se banco de dados não existe
                connection = null;
                createDatabase();
            }
        }
    }
    
    private void createDatabase() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement stm = connection.createStatement();
            int result = stm.executeUpdate("CREATE DATABASE grade");
            connection.close();
            connection = null;
            connect();
            createTables();
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
                        "(id INTEGER not NULL, " +
                        " nome VARCHAR(255), " + 
                        " matricula INTEGER, " + 
                        " PRIMARY KEY ( id ))"; 

            String disciplinaTableSQL = "CREATE TABLE disciplina " +
                        "(id INTEGER not NULL, " +
                        " nome VARCHAR(255), " + 
                        " creditos INTEGER, " + 
                        " PRIMARY KEY ( id ))"; 

            String salaTableSQL = "CREATE TABLE sala " +
                        "(id INTEGER not NULL, " +
                        " numero INTEGER, " + 
                        " predio VARCHAR(255), " +
                        " PRIMARY KEY ( id ))"; 
            
            String gradeTableSQL = "CREATE TABLE grade " +
                        "(id INTEGER not NULL, " +
                        " nome VARCHAR(255), " + 
                        " criacao DATETIME, " + 
                        " PRIMARY KEY ( id ))"; 

            String turmaTableSQL = "CREATE TABLE turma " +
                        "(id INTEGER not NULL, " +
                        " nome VARCHAR(5), " + 
                        " disciplina INTEGER, " + 
                        " horario INTEGER, " +
                        " professor INTEGER, " + 
                        " dia INTEGER, " + 
                        " hora TIME, " + 
                        " sala INTEGER, " + 
                        " grade INTEGER, " + 
                        " PRIMARY KEY ( id )," +
                        "FOREIGN KEY (sala) REFERENCES sala(id)," +
                        "FOREIGN KEY (disciplina) REFERENCES disciplina(id)," +
                        "FOREIGN KEY (professor) REFERENCES professor(id)," +
                        "FOREIGN KEY (grade) REFERENCES grade(id))";  


            stmt.addBatch(professorTableSQL);
            stmt.addBatch(disciplinaTableSQL);
            stmt.addBatch(salaTableSQL);
            stmt.addBatch(gradeTableSQL);
            stmt.addBatch(turmaTableSQL);
            stmt.executeBatch();
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // TODO Tratar erros do banco de dados
        }
    }
    
}
