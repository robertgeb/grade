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
import java.util.ArrayList;

/**
 *
 * @author robert
 */
public class Bd {
    
    private Connection connection = null;
    private String databaseUser = "root";
    private String databasePassword = "";
    
    private String insertDisciplinasSQL[] = {"INSERT INTO disciplina (nome, creditos, periodo) " +
        "VALUES (\"LINGUAGEM DE PROGRAMAÇÃO I\", 4, 1)",
        "INSERT INTO disciplina (nome, creditos, periodo) " +
        "VALUES (\"INTRODUÇÃO A SISTEMAS DE INFORMAÇÃO\", 2, 1)",
        "INSERT INTO disciplina (nome, creditos, periodo) " +
        "VALUES (\"INTRODUÇÃO A SISTEMAS DIGITAIS\", 4, 1)"};
    
    private String insertProfessoresSQL[] = {"INSERT INTO professor (nome, matricula) " +
        "VALUES (\"Gizelle Kupac. Vianna\", 1547743)",
        "INSERT INTO professor (nome, matricula)" +
        "VALUES (\"Luiz Maltar Castello Branco\", 361291)",
        "INSERT INTO professor (nome, matricula) " +
        "VALUES (\"Eduardo Kinder Almentero\", 4123410)"};
    
    private String insertTurmasSQL[] = {"INSERT INTO turma (nome, professor, disciplina) " +
        "VALUES (\"T01\", 1, 1)",
        "INSERT INTO turma (nome, professor, disciplina) " +
        "VALUES (\"T01\", 3, 2)",
        "INSERT INTO turma (nome, professor, disciplina) " +
        "VALUES (\"T01\", 2, 3);"};
    
    Bd() {
        connect();
    }
    
    
    private void connect(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grade", databaseUser, databasePassword);
        } catch(SQLException ex){
            System.out.println("Erro no banco de dados:");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            if(ex.getErrorCode() == 1049){  // Se banco de dados não existe
                createDatabase();
                connect();
            }
        } finally {
            disconnect();
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
    
    private void createDatabase() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", databaseUser, databasePassword);
            Statement stm = connection.createStatement();
            int result = stm.executeUpdate("CREATE DATABASE grade");
            disconnect();
            connect();
            createTables();
            disconnect();
            connect();
            insertSampleData();
            disconnect();
            System.out.println("Novo banco criado e populado com sucesso");
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // TODO Tratar erros do banco de dados
        }
    }
    
    private void insertSampleData() {
        try{
            Statement stmt = null;

            stmt = connection.createStatement();
            for(String sql: insertDisciplinasSQL){
                stmt.addBatch(sql);
            }
            for(String sql: insertProfessoresSQL){
                stmt.addBatch(sql);
            }
            for(String sql: insertTurmasSQL){
                stmt.addBatch(sql);
            }
            stmt.executeBatch();
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
                        " abreviatura VARCHAR(5), " + 
                        " creditos INTEGER, " + 
                        " periodo INTEGER, " + 
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
                        " dia INTEGER, " + 
                        " hora TIME, " + 
                        " grade INTEGER, " +
                        " PRIMARY KEY ( id )," +
                        "FOREIGN KEY (turma) REFERENCES turma(id)," +
                        "FOREIGN KEY (grade) REFERENCES grade(id))";  

            String alocacaoTableSQL = "CREATE TABLE alocacao " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " horario INTEGER, " + 
                        " sala INTEGER, " +
                        " PRIMARY KEY ( id )," +
                        "FOREIGN KEY (horario) REFERENCES horario(id))";  
            
            stmt.addBatch(professorTableSQL);
            stmt.addBatch(disciplinaTableSQL);
            stmt.addBatch(predioTableSQL);
            stmt.addBatch(salaTableSQL);
            stmt.addBatch(gradeTableSQL);
            stmt.addBatch(turmaTableSQL);
            stmt.addBatch(horarioTableSQL);
            stmt.addBatch(alocacaoTableSQL);
            stmt.executeBatch();
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // TODO Tratar erros do banco de dados
        }
    }
    
}